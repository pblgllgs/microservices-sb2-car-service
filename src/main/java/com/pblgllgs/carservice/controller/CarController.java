package com.pblgllgs.carservice.controller;

import com.pblgllgs.carservice.entity.Car;
import com.pblgllgs.carservice.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/car")
public class CarController {

    private final CarService carService;


    @PostMapping
    public ResponseEntity<Car> save(@RequestBody Car car){
        return new ResponseEntity<>(carService.save(car), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable("id") int id){
        return new ResponseEntity<>(carService.findCarById(id),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars(){
        List<Car> cars = carService.getAll();
        if (cars == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Car>> findAllCarsByUserId(@PathVariable("userId") int userId){
        List<Car> cars = carService.findUsersByUserId(userId);
        if (cars == null) {
            return ResponseEntity.noContent().build();
        }
        return new ResponseEntity<>(cars,HttpStatus.OK);
    }
}
