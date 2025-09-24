package reactive.memo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CareerDto {

  private long id;
  private String name;
  private int members;
  private String mainTask;
  private String duration;
  private Object details;
  private String companyName;
  
}
