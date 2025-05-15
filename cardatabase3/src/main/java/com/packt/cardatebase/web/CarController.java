package com.packt.cardatebase.web;

import com.packt.cardatebase.domain.Car;
import com.packt.cardatebase.domain.CarRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/cars")
    private Iterable<Car> getCars(){
        return repository.findAll();
    }
}
