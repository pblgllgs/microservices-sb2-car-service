package com.pblgllgs.carservice.service;

import com.pblgllgs.carservice.entity.Car;
import com.pblgllgs.carservice.exception.CarNotFoundException;
import com.pblgllgs.carservice.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getAll() {
        return carRepository.findAll();
    }

    public Car findCarById(int id) {
        return carRepository.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found with id: "+id));
    }

    public Car save(Car car) {
        return carRepository.save(car);
    }

    public List<Car> findUsersByUserId(int userId){
        return carRepository.findCarByUserId(userId);
    }
}
