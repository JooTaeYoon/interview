package reactive.memo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactive.memo.dto.PracticeHistoryDto;
import reactive.memo.mapper.PracticeHistoryMapper;

@Service
@Slf4j
public class PracticeHistoryService {

    private final PracticeHistoryMapper practiceHistoryMapper;

    public PracticeHistoryService(PracticeHistoryMapper practiceHistoryMapper) {
        this.practiceHistoryMapper = practiceHistoryMapper;
    }

    public int savePracticeHistory(PracticeHistoryDto practiceHistoryDto) {
        int i = practiceHistoryMapper.savePracticeHistory(practiceHistoryDto);
        return i;
    }


}
