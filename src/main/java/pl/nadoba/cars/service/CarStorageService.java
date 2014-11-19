package pl.nadoba.cars.service;

import java.util.*;

import com.example.servletjspdemo.domain.Person;
import pl.nadoba.cars.model.Car;

public class CarStorageService {

	// HashMap < UUID, CAR > stores all cars known to computer
	Map<UUID, Car> cars = new HashMap<UUID, Car>();

	public void store(Car car) {
		cars.put(car.getUuid(), car);
	}
	
	public Car getCar(UUID uuid) {
		return cars.get(uuid);
	}

	public void delete(UUID uuid) {
		cars.remove(uuid);
	}

	public Map<UUID, Car> getMap() {
		return cars;
	}

	public void editCar(UUID uuid, Car car) {
		cars.remove(uuid);
		cars.put(uuid, car);
	}
}
