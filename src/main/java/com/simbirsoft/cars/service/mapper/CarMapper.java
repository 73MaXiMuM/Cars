package com.simbirsoft.cars.service.mapper;

import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.entity.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarDto toDto(Car car) {
        CarDto carDto = new CarDto();
        carDto.setManufacturer(car.getManufacturer());
        carDto.setModel(car.getModel());
        return carDto;
    }

    public Car toEntity(CarDto carDto) {
        Car car = new Car();
        car.setManufacturer(carDto.getManufacturer());
        car.setModel(carDto.getModel());
        return car;
    }
}