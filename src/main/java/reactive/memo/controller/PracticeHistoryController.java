package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.memo.dto.PracticeHistoryDto;
import reactive.memo.service.PracticeHistoryService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/practicehistory")
@Slf4j
public class PracticeHistoryController {

    private final PracticeHistoryService practiceHistoryService;

    public PracticeHistoryController(PracticeHistoryService practiceHistoryService) {
        this.practiceHistoryService = practiceHistoryService;
    }

    @PostMapping("/save_practicehistory")
    public ResponseEntity<?> savePracticeHistory(@RequestBody PracticeHistoryDto practiceHistoryDto) {
        log.info("| START |");
        int i = practiceHistoryService.savePracticeHistory(practiceHistoryDto);
        Map<String, String> result = new HashMap<>();
        if (i == 1) {
            result.put("result", "ok");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        result.put("result", "fail");
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
