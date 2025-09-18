package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.CategoryDto;

@Mapper
public interface CategoryMapper {

    public int saveCategory(CategoryDto categoryDto);
}
