package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import reactive.memo.dto.BoardDto;

import java.util.*;

@Mapper
public interface BoardMapper {

    public List<BoardDto> boardList(@Param("offset") int offset, @Param("limit") int limit);

    public void save(BoardDto boardDto);

    public List<BoardDto> read();

    public BoardDto getOne(Long id);

    public void deleteBoard(Long id);

    public int update(BoardDto boardDto);
}