package reactive.memo.service;

import org.springframework.stereotype.Service;
import reactive.memo.dto.CategoryDto;
import reactive.memo.mapper.CategoryMapper;

@Service
public class CategoryService {

    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    public int saveCategory(CategoryDto categoryDto) {
        int i = categoryMapper.saveCategory(categoryDto);
        return i;
    }

}
