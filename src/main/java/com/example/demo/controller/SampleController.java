package com.example.demo.controller;


import com.example.demo.car.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("test")
public class SampleController {
    //cwiczenie 1
    @GetMapping("hello")
    public ResponseEntity<String> getHello() {
        return ResponseEntity.ok("Hello world");
    }
    //cwiczenie 2
    @GetMapping("getCorolla")
    public ResponseEntity<Car> getCar() {
        return ResponseEntity.ok(new Car("Toyota", "Corolla", 2011));
    }
    //cwiczenie 3
    @GetMapping("hello/{someValue}")
    public ResponseEntity<String> getSomeValue(@PathVariable String someValue) {
        return ResponseEntity.ok(someValue);
    }
    //cwiczenie 4
    @GetMapping(value = "/hello", params = {"someValue"})
    public ResponseEntity<String> getReqParam(@RequestParam String someValue) {
        return ResponseEntity.ok(someValue);
    }
    //cwiczenie 5
    @PostMapping("makeCar")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = Car.builder()
                .brand(car.getBrand())
                .model(car.getModel())
                .productionYear(car.getProductionYear())
                .build();
        return ResponseEntity.ok(newCar);
    }
}
