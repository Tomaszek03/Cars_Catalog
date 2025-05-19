package com.tomaszek.carscatalog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarsCatalogService {
    private final CarsCatalogRepository carsCatalogRepository;

    public CarsCatalogService(CarsCatalogRepository carsCatalogRepository) {
        this.carsCatalogRepository = carsCatalogRepository;
    }

    public List<Car> getAllCars() {
        return carsCatalogRepository.findAll();
    }

    public Car addCar(Car car) {
        return carsCatalogRepository.save(car);
    }
}
