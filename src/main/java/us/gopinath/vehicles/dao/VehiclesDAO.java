package us.gopinath.vehicles.dao;

import java.util.List;
import us.gopinath.vehicles.model.Vehicle;

public interface VehiclesDAO {

	boolean insertVehicle(Vehicle vehicle);
    boolean updateVehicle(Vehicle vehicle);
    boolean deleteVehicle(long id);
    List<Vehicle> findAll();
    Vehicle findById(long id);
    List<Vehicle> findByModel(String model);
	List<Vehicle> findByBrand(String brand);
	List<Vehicle> findByYear(int year);
	List<Vehicle> findBySpeed(int speed);
	List<Vehicle> findByType(String type);
	List<Vehicle> findByDescription(String description);
}
