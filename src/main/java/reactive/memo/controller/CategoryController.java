package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.memo.dto.CategoryDto;
import reactive.memo.service.CategoryService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/category")
@Slf4j
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/save_category")
    public ResponseEntity<?> saveCategory(@RequestBody CategoryDto categoryDto) {
        log.info("| SAVE_CATEGORY |" + categoryDto);
        Map<String, String> result = new HashMap<>();
        int i = categoryService.saveCategory(categoryDto);
        if (i == 1) {
            result.put("result", "ok");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        result.put("result", "fail");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }


}
