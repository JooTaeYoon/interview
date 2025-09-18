package reactive.memo.mapper;

import org.apache.ibatis.annotations.Mapper;
import reactive.memo.dto.UserDto;

@Mapper
public interface UserMapper {

    UserDto findByUser(String userName);

    int saveUser(UserDto userDto);
}
