package com.tomaszek.carscatalog;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carscatalog")
public class AppController {
    private final CarsCatalogService carsCatalogService;

    public AppController(CarsCatalogService carsCatalogService) {
        this.carsCatalogService = carsCatalogService;
    }

    @GetMapping
    public List<Car> getCars() {
        return carsCatalogService.getAllCars();
    }

    @PostMapping
    public void addCar(@RequestBody Car car) {
        carsCatalogService.addCar(car);
    }
}
