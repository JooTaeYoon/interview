package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.PracticeHistoryDto;

@Mapper
public interface PracticeHistoryMapper {

    public int savePracticeHistory(PracticeHistoryDto practiceHistoryDto);

}
