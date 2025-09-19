package reactive.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PracticeHistoryDto {

    private long id;
    private int userId;
    private int questionId;
    private Date practicedAt;
}
