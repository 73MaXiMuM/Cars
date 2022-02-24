package com.simbirsoft.cars.service;

import com.simbirsoft.cars.dto.CarDto;

import java.util.List;

public interface CarService {

    CarDto createCar(CarDto carDto);

    List<CarDto> findAll();

    void delete(Long id);
}