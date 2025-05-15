package com.packt.cardatabase2.web;

import com.packt.cardatabase2.domain.Car;
import com.packt.cardatabase2.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars") // 정보를 가져오는 애너테이션
    public Iterable<Car> getCars(){
        //자동차를 검색하고나서 반환
        return  repository.findAll();
    }
}
