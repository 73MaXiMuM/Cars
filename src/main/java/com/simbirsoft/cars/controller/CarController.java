package com.simbirsoft.cars.controller;

import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Car controller", description = "Car management / Управление автомобилями")
@RestController
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto carDto) {
        return ResponseEntity.ok(carService.createCar(carDto));
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> findAll() {
        return ResponseEntity.ok(carService.findAll());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        carService.delete(id);
        return ResponseEntity.ok("Ok.");
    }
}