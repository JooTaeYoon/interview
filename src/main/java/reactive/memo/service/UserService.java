package reactive.memo.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactive.memo.dto.UserDto;
import reactive.memo.mapper.UserMapper;

@Service
@Slf4j
public class UserService {

    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserMapper userMapper, PasswordEncoder passwordEncoder) {
        this.userMapper = userMapper;
        this.passwordEncoder = passwordEncoder;
    }


    public int saveUser(UserDto userDto) {
        log.info("| | START | |");

        if (userDto.getName() == "" || userDto.getName() == null) {
            return -1;
        }
        if (userDto.getPassword() == "" || userDto.getPassword() == null) {
            return -1;
        }

        log.info("userDto: {}", userDto);
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        int i = userMapper.saveUser(userDto);
        log.info("| | i => {} | |", i);
        log.info("| | END | |");
        return i;
    }

    public UserDto login(UserDto userDto) throws IllegalAccessException {
        UserDto userDto1 = userMapper.findByUser(userDto.getName());
        log.info("userDto1: {}", userDto1);
        if (!passwordEncoder.matches(userDto.getPassword(), userDto1.getPassword())) {
            throw new IllegalAccessException("비밀번호가 틀렸습니다");
        }
        return userDto1;
    }
}
