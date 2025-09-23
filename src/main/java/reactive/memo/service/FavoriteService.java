package reactive.memo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import reactive.memo.dto.PracticeHistoryDto;
import reactive.memo.mapper.FavoriteMapper;

@Service
@Slf4j
public class FavoriteService {


    private final FavoriteMapper favoriteMapper;

    public FavoriteService(FavoriteMapper favoriteMapper) {
        this.favoriteMapper = favoriteMapper;
    }

    public int like(Long id) {
        int questionLike = favoriteMapper.like(id);

        log.info("| | START >>> {} | | ", id);
        if (questionLike == 1) {
            //            int saveFavorite = favoriteMapper.likeFavorite(id);
            PracticeHistoryDto questionId = favoriteMapper.getQuestionId(id);
            log.info("questionId >>> {} ", questionId);
            int saveFavorite = saveLike(questionId);
            log.info("| | saveFavorite >>> {} | |", saveFavorite);
            // log.info("| | questionId >>> {} | |", questionId.getId());
        }
        return questionLike;
    }
    
    @Transactional
    public int saveLike(PracticeHistoryDto id) {
        int saveFavorite = favoriteMapper.likeFavorite(id);
        log.info("| | saveFavorite >>> {} | |", saveFavorite);
        return saveFavorite;
    }

    @Transactional
    public int unlike(Long id) {
        log.info("| | id >>> {} | |", id);
        int questionUnlike = favoriteMapper.unlike(id);
        log.info("questionUnlike >>> {}", questionUnlike);
        if (questionUnlike == 1) {
            int i = favoriteMapper.unlikeFavorite(id);
        }
        return questionUnlike;
    }

}
