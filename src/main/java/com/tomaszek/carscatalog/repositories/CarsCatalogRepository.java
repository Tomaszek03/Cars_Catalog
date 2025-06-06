package com.tomaszek.carscatalog.repositories;

import com.tomaszek.carscatalog.models.Car;
import jakarta.validation.constraints.Positive;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsCatalogRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrandIgnoreCase(String brand);
    List<Car> findByYearOfProductionBetween(int fromYear, int toYear);
    List<Car> findByPriceBetween(double price, double price2);
}
