package reactive.memo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactive.memo.dto.QuestionDto;
import reactive.memo.mapper.QuestionMapper;

@Service
@Slf4j
public class QuestionService {

    private final QuestionMapper questionMapper;

    public QuestionService(QuestionMapper questionMapper) {
        this.questionMapper = questionMapper;
    }

    public int saveQuestion(QuestionDto questionDto) {
        log.info("| | SAVE SERVICE {} | | ", questionDto);
        int i = questionMapper.saveQuestion(questionDto);
        return i;
    }
}
