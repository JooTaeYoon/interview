package reactive.memo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactive.memo.dto.BoardDto;
import reactive.memo.service.BoardService;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Slf4j
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/board")
    public ResponseEntity<?> listBoard() {
        log.info("| START |");
        BoardDto boardDto = BoardDto.builder()
                .title("제목입니다야 이거 맞냐ㅋㅋㅋ").writer("글쓴이글쓴이 원투").id(1)
                .build();

        List<BoardDto> boardDtoList = List.of(boardDto);

        return ResponseEntity.status(HttpStatus.OK).body(boardDtoList);
    }


    @PostMapping(value = "/saveProfile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> saveProfile(@RequestPart(value = "file", required = false) MultipartFile imageUri, @RequestParam(value = "name", required = false) String name,
                                         @RequestHeader(value = "X-Custom-Header", required = false) String customHeader, // 특정 헤더
                                         @RequestHeader Map<String, String> headers         // 모든 헤더 맵
    ) {
        System.out.println("api called!");
        System.out.println("imageUri: " + imageUri + " , " + name);
        try {
            Path path = Paths.get("/Users/taeyoonjoo/Desktop/ing");
            Files.createDirectories(path);

            if (imageUri != null && name != null) {
                String fileName = System.currentTimeMillis() + "_" + imageUri.getOriginalFilename();
                Path filePath = path.resolve(fileName);
                System.out.println("filePath : " + filePath);
                imageUri.transferTo(filePath.toFile());

                System.out.println("name = " + name);
                System.out.println("customHeader = " + customHeader);
                System.out.println("all headers = " + headers);

                String fileUrl = "/Users/taeyoonjoo/Desktop/ing/" + fileName;
                return ResponseEntity.ok(Map.of("url", fileUrl, "filename", fileName));
            }

        } catch (Exception e) {
            System.out.println("fail!");
            throw new RuntimeException(e);
        }
        return ResponseEntity.status(HttpStatus.OK).body("ok!");
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody BoardDto boardDto) {
        log.info("| API SAVE | >>> {}", boardDto);
        boardService.save(boardDto);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @GetMapping("/read")
    public ResponseEntity<?> read() {
        log.info("| START |");
        List<BoardDto> read = boardService.read();
        log.info("read: {}", read);
        return ResponseEntity.status(HttpStatus.OK).body(read);
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        log.info("| id : {} |", id);
        BoardDto one = boardService.getOne(id);

        log.info("| getOne: {} |", one);
        if (one == null) {
            return ResponseEntity.status(201).body("noData");
        }
        return ResponseEntity.status(HttpStatus.OK).body(one);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        log.info("| delete: {} |", id);
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        int realId = (int) id.longValue();
        boardDto.setId(realId);
        log.info("| BEFOR: {}", boardDto);
        int update = boardService.update(boardDto);
        log.info("| AFTER : {} |", update);
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

}
