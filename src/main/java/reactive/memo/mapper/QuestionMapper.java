package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.QuestionDto;

@Mapper
public interface QuestionMapper {

    public int saveQuestion(QuestionDto questionDto);


}
