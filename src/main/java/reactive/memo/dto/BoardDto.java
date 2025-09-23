package reactive.memo.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDto {
    private long id;
    private String title;
    private String writer;
    private String content;
    private Date create_at;
}
