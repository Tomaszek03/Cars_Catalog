package com.tomaszek.carscatalog;

import com.tomaszek.carscatalog.models.Car;
import com.tomaszek.carscatalog.repositories.CarsCatalogRepository;
import com.tomaszek.carscatalog.services.CarsCatalogService;
import com.tomaszek.carscatalog.utils.TestLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith({MockitoExtension.class, TestLogger.class})
public class CarsCatalogUnitTests {

    @Mock
    private CarsCatalogRepository repository;

    @InjectMocks
    private CarsCatalogService service;

    @Test
    void getAllCars_test() {
        Car mockCar = new Car(1, "Dodge", "Challenger SRT Hellcat", 2020,
                "Lime green", "V8 6.2L", 717, 300000.0);
        when(repository.findAll()).thenReturn(List.of(mockCar));

        List<Car> cars = service.getAllCars();

        assertThat(cars)
                .hasSize(1)
                .first()
                .satisfies(car -> {
                    assertThat(car.getBrand()).isEqualTo("Dodge");
                    assertThat(car.getModel()).isEqualTo("Challenger SRT Hellcat");
                });
    }

    @Test
    void findCarById_test() {
        Car mockCar = new Car(1, "Dodge", "Challenger SRT Hellcat", 2020,
                "Lime green", "V8 6.2L", 717, 300000.0);
        when(repository.findById(1)).thenReturn(java.util.Optional.of(mockCar));

        var result = service.findCarById(1);

        assertThat(result).isPresent();
        assertThat(result.get().getModel()).isEqualTo("Challenger SRT Hellcat");
    }

    @Test
    void findCarsByBrand_test() {
        Car car1 = new Car(1, "Lamborghini", "Huracan EVO", 2020,
                "Yellow", "V10 5.2L", 640, 1300000.0);
        Car car2 = new Car(2, "Lamborghini", "Aventador SVJ", 2018,
                "Red", "V12 6.5L", 770, 2900000.0);
        when(repository.findByBrandIgnoreCase("Lamborghini")).thenReturn(List.of(car1, car2));

        List<Car> cars = service.findCarsByBrand("Lamborghini");

        assertThat(cars).hasSize(2).extracting(Car::getModel).containsExactly("Huracan EVO", "Aventador SVJ");

    }

    @Test
    void findCarsByYearRange_test() {
        Car car1 = new Car(1, "Toyota", "Supra MK4", 1998, "White", "2JZ-GE 3.0L", 220, 120000.0);
        Car car2 = new Car(2, "Nissan", "Skyline R34 GTR", 1999, "Silver", "RB26DETT 2.6L", 280, 140000.0);
        when(repository.findByYearOfProductionBetween(1995, 2000)).thenReturn(List.of(car1, car2));

        List<Car> result = service.findCarsByYearRange(1995, 2000);

        assertThat(result)
                .hasSize(2)
                .extracting(Car::getBrand)
                .contains("Toyota", "Nissan");
    }

    @Test
    void findCarsByPriceRange_test() {
        Car car1 = new Car(1, "Toyota", "Supra MK4", 1998, "White", "2JZ-GE 3.0L", 220, 120000.0);
        Car car2 = new Car(2, "Nissan", "Skyline R34 GTR", 1999, "Silver", "RB26DETT 2.6L", 280, 140000.0);
        when(repository.findByPriceBetween(100000, 130000)).thenReturn(List.of(car1));

        List<Car> result = service.findCarsByPriceRange(100000, 130000);

        assertThat(result)
                .hasSize(1)
                .extracting(Car::getBrand)
                .contains("Toyota");
    }

    @Test
    void deleteCarById_test() {
        service.deleteById(5);
        org.mockito.Mockito.verify(repository).deleteById(5);
    }



}