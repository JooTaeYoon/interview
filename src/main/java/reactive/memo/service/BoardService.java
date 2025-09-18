package reactive.memo.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactive.memo.dto.BoardDto;
import reactive.memo.mapper.BoardMapper;

import java.util.List;

@Slf4j
@Service
public class BoardService implements BoardMapper {

    private final BoardMapper boardMapper;

    public BoardService(BoardMapper boardMapper) {
        this.boardMapper = boardMapper;
    }


    @Override
    public List<BoardDto> boardList(int offset, int limit) {
        List<BoardDto> boardDtos = boardMapper.boardList(offset, limit);
        return boardDtos;
    }

    @Override
    public void save(BoardDto boardDto) {
        boardMapper.save(boardDto);
    }

    @Override
    public List<BoardDto> read() {
        List<BoardDto> read = boardMapper.read();
        try {
            if (read == null) {
                log.info("read: {}",read);
                return null;
            }
        } catch (Exception e) {
            log.info("error: " + e.getMessage());
        }
        log.info("read : {}", read);
        return read;
    }

    @Override
    public BoardDto getOne(Long id) {
        BoardDto one = boardMapper.getOne(id);
        return one;
    }

    @Override
    public void deleteBoard(Long id) {
        boardMapper.deleteBoard(id);
        return;
    }

    @Override
    public int update(BoardDto boardDto) {
        log.info("| | Service START || ");
        int update = boardMapper.update(boardDto);
        log.info("| | Service END: {} || ", update);
        return update;
    }
}
