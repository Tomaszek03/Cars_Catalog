package com.tomaszek.carscatalog;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarsCatalogRepository extends JpaRepository<Car, Integer> {
}
