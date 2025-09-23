package reactive.memo.dto;

import lombok.*;

import java.util.Date;


@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PracticeHistoryDto {

    private long id;
    private long userId;
    private int questionId;
    private Date practicedAt;
}
