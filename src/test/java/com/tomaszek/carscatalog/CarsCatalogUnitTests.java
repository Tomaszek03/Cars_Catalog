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
        // Arrange
        Car mockCar = new Car(1, "Dodge", "Challenger SRT Hellcat", 2020,
                "Lime green", "V8 6.2L", 717, 300000.0);
        when(repository.findAll()).thenReturn(List.of(mockCar));

        // Act
        List<Car> cars = service.getAllCars();

        // Assert
        assertThat(cars)
                .hasSize(1)
                .first()
                .satisfies(car -> {
                    assertThat(car.getBrand()).isEqualTo("Dodge");
                    assertThat(car.getModel()).isEqualTo("Challenger SRT Hellcat");
                });
    }
}