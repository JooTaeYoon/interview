package reactive.memo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import reactive.memo.dto.CareerDto;

@Mapper
public interface CareerMapper {

  List<CareerDto> getCareer(long id);
  
}
