package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactive.memo.service.FavoriteService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/favorite")
@Slf4j
public class FavoriteController {


    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }

    @GetMapping("/{id}/like")
    public ResponseEntity<?> like(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();
        int like = favoriteService.like(id);
        if (like == 1) {
            result.put("result", "ok");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(Map.of("result", "fail"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/unlike")
    public ResponseEntity<?> unlike(@PathVariable Long id) {
        Map<String, Object> result = new HashMap<>();

        int unlike = favoriteService.unlike(id);
        if (unlike == 1) {
            result.put("result", "okd");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        return new ResponseEntity<>(Map.of("result", "fail"), HttpStatus.OK);
    }
    

}
