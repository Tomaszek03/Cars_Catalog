package com.tomaszek.carscatalog;

import com.tomaszek.carscatalog.models.Car;
import com.tomaszek.carscatalog.repositories.CarsCatalogRepository;
import com.tomaszek.carscatalog.utils.TestLogger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
@ExtendWith({TestLogger.class})
class CarsCatalogIntegrationTests {

	@Autowired
	private CarsCatalogRepository carsCatalogRepository;

	@Test
	void contextLoads(TestInfo testInfo) {
		System.out.println("Running test: " + testInfo.getDisplayName());
		assertThat(carsCatalogRepository).isNotNull();
	}

	@Test
	void getAllCars_test(TestInfo testInfo) {
		System.out.println("Running test: " + testInfo.getDisplayName());
		List<Car> cars = carsCatalogRepository.findAll();

		assertThat(cars).isNotEmpty();
		assertThat(cars.size()).isGreaterThanOrEqualTo(1);
		assertThat(cars)
				.extracting(Car::getBrand)
				.isNotEmpty()
				.doesNotContainNull();
	}
}