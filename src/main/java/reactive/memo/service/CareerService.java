package reactive.memo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import reactive.memo.mapper.CareerMapper;

@Service
@Slf4j
public class CareerService {

  private final CareerMapper careerMapper;

  public CareerService(CareerMapper careerMapper) {
    this.careerMapper = careerMapper;
  }

  public List<?> getCareer(Long id) {
    
    List<?> getCareer = careerMapper.getCareer(id);
    log.info("getCareer >>> {}", getCareer);
    if (getCareer != null) {
      log.info("getCareer is null >>> {}", getCareer);
      return getCareer;
    }

    return getCareer;
  }
  
}
