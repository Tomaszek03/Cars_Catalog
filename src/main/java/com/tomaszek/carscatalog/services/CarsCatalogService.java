package com.tomaszek.carscatalog.services;

import com.tomaszek.carscatalog.models.Car;
import com.tomaszek.carscatalog.repositories.CarsCatalogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Car> findCarsByBrand(String brand) {
        return carsCatalogRepository.findByBrandIgnoreCase(brand);
    }

    public List<Car> findCarsByYearRange(int fromYear, int toYear) {
        return carsCatalogRepository.findByYearOfProductionBetween(fromYear, toYear);
    }

    public Optional<Car> findCarById(int id) {
        return carsCatalogRepository.findById(id);
    }

    public void deleteById(int id) {
        carsCatalogRepository.deleteById(id);
    }
}
