package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.UserDto;
import reactive.memo.dto.UserHistoryDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {

    UserDto findByUser(String userName);

    int saveUser(UserDto userDto);

    List<UserHistoryDto> getHistory(Long id);
}
