package reactive.memo.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserHistoryDto {

    private String questionContent;
    private String userName;
    private String categoryName;

}
