package pl.nadoba.cars.model;


import java.util.UUID;

public class Car {

	private UUID uuid = UUID.randomUUID();
	private String make = "BMW";
	private String model = "";
	private BodyStyle bodyStyle = BodyStyle.coupe;
	private FuelType fuelType = FuelType.petrol;
	private int engineCapacity = 0;
	private int horsepower = 0;
	private String color = "";

	public enum BodyStyle { coupe, estate, hatchback, sedan }

	public enum FuelType { petrol, diesel, autogas, hybrid }

	public Car() {
	}

	public Car(String make, String model, BodyStyle bodyStyle, FuelType fuelType, int engineCapacity, int horsepower, String color) {
		this.make = make;
		this.model = model;
		this.bodyStyle = bodyStyle;
		this.fuelType = fuelType;
		this.engineCapacity = engineCapacity;
		this.horsepower = horsepower;
		this.color = color;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public BodyStyle getBodyStyle() {
		return bodyStyle;
	}

	public FuelType getFuelType() {
		return fuelType;
	}

	public int getEngineCapacity() {
		return engineCapacity;
	}

	public int getHorsepower() {
		return horsepower;
	}

	public String getColor() {
		return color;
	}
}
