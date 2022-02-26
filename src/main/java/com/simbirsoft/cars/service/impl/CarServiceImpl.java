package com.simbirsoft.cars.service.impl;

import com.simbirsoft.cars.dto.CarDto;
import com.simbirsoft.cars.entity.Car;
import com.simbirsoft.cars.exception.CarIdNotFoundException;
import com.simbirsoft.cars.repository.CarRepository;
import com.simbirsoft.cars.service.CarService;
import com.simbirsoft.cars.service.mapper.CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Autowired
    public CarServiceImpl(CarRepository carRepository,
                          CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    @Override
    public CarDto createCar(CarDto carDto) {
        return carMapper.toDto(
                carRepository.save(carMapper.toEntity(carDto)));
    }

    @Override
    public List<CarDto> findAll() {
        return carRepository.findAll()
                .stream()
                .map((carMapper::toDto))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Long id) {
        Car car = carRepository.findById(id)
                .orElseThrow(() -> new CarIdNotFoundException(id));
        carRepository.delete(car);
    }
}