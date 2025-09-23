package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.PracticeHistoryDto;

@Mapper
public interface FavoriteMapper {

    int like(Long id);

    int unlike(Long id);

    int likeFavorite(PracticeHistoryDto id);

    int unlikeFavorite(Long id);

    PracticeHistoryDto getQuestionId(Long id);
}
