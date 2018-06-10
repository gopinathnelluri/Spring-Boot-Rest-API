package us.gopinath.vehicles.model;

public class Vehicle {
	long vehicle_id; 
	String brand;
	String model;
	int year; 
	String speed; 
	String type; 
	String description;
	
	public Vehicle() {
		super();
	}

	public Vehicle(String brand, String model, int year, String speed, String type,
			String description) {
		super();
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.speed = speed;
		this.type = type;
		this.description = description;
	}
	
	public Vehicle(long vehicle_id, String brand, String model, int year, String speed, String type,
			String description) {
		super();
		this.vehicle_id = vehicle_id;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.speed = speed;
		this.type = type;
		this.description = description;
	}
	
	
	
	public long getVehicle_id() {
		return vehicle_id;
	}
	public void setVehicle_id(long vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSpeed() {
		return speed;
	}
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	@Override
	public String toString() {
		return "Vehicle [vehicle_id=" + vehicle_id + ", brand=" + brand + ", model=" + model + ", year=" + year
				+ ", speed=" + speed + ", type=" + type + ", description=" + description + "]";
	}
}
