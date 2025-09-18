package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.memo.dto.QuestionDto;
import reactive.memo.service.QuestionService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/questions")
@Slf4j
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/save_question")
    public ResponseEntity<?> saveQuestion(@RequestBody QuestionDto questionDto) {
        Map<String, String> result = new HashMap<>();

        int i = questionService.saveQuestion(questionDto);
        if(i == 1){
            result.put("result", "ok");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        result.put("result", "fail");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
