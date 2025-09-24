package reactive.memo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import reactive.memo.service.CareerService;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/career")
@Slf4j
public class CareerController {

  private final CareerService careerService;


  public CareerController(CareerService careerService) {
    this.careerService = careerService;
  }


  @GetMapping("/{id}/get_career")
  public ResponseEntity<?> getCareer(@PathVariable Long id) {
    //TODO: process POST request
    log.info("| START | GET_CAREER | id >>> {} ", id);
      List<?> get = careerService.getCareer(id);
      log.info("get >>> {}", get);
      if (get == null) {
        return new ResponseEntity<>(Map.of("result", "fail"), HttpStatus.OK);
      }
      return new ResponseEntity<>(get, HttpStatus.OK);
    }
    
  
}
