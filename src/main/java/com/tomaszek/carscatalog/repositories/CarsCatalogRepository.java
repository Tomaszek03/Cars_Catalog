package com.tomaszek.carscatalog.repositories;

import com.tomaszek.carscatalog.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsCatalogRepository extends JpaRepository<Car, Integer> {
    List<Car> findByBrandIgnoreCase(String brand);

    List<Car> findByYearOfProductionBetween(int fromYear, int toYear);
}
