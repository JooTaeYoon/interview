package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactive.memo.config.JwtTokenProvider;
import reactive.memo.dto.UserDto;
import reactive.memo.service.UserService;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@Slf4j
public class UserController {

    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;

    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }


    @PostMapping("/saveUser")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        log.info("| API/USER/SAVE |");
        int i = userService.saveUser(userDto);
        Map<String, String> result = new HashMap<>();
        if (i == 1) {
            log.info("| 가입 성공 |");
            result.put("msg", userDto.getName() + "가입을 축하합니다.");
            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
        result.put("msg", "다 기입 해주세요");
        log.info("| 가입 실패 |");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) throws IllegalAccessException {
        UserDto login = userService.login(userDto);
        Map<String, String> result = new HashMap<>();
        String jwtToken = jwtTokenProvider.createToken(String.valueOf(login.getId()), login.getRole());
        result.put("token", jwtToken);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    @PostMapping("/refresh")
    public ResponseEntity<?> refresh(@RequestBody UserDto userDto) throws IllegalAccessException {
        log.info("| START |");
        UserDto login = userService.login(userDto);
        String jwtToken = jwtTokenProvider.createToken(String.valueOf(login.getId()), login.getRole());
        return new ResponseEntity<>(jwtToken, HttpStatus.OK);
    }

    @GetMapping("/{id}/history")
    public ResponseEntity<?> userHistory(@PathVariable Long id) {
        log.info("| id >>> {} |",id);
        Map<String, Object> history = userService.getHistory(id);
        if (history != null) {
            return new ResponseEntity<>(history, HttpStatus.OK);
        } else return new ResponseEntity<>(history.put("result", "fail"), HttpStatus.OK);

    }
}
