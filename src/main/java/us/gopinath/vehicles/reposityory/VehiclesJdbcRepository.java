package us.gopinath.vehicles.reposityory;

import us.gopinath.vehicles.model.Vehicle;
import us.gopinath.vehicles.dao.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class VehiclesJdbcRepository implements VehiclesDAO{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	class VehicleRowMapper implements RowMapper<Vehicle> {
		@Override
		public Vehicle mapRow(ResultSet rs, int rowNum) throws SQLException {
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicle_id(rs.getLong("vehicle_id"));
			vehicle.setBrand(rs.getString("brand"));
			vehicle.setModel(rs.getString("model"));
			vehicle.setSpeed(rs.getString("speed"));
			vehicle.setType(rs.getString("type"));
			vehicle.setYear(rs.getInt("year"));
			vehicle.setDescription(rs.getString("description"));
			return vehicle;
		}
	}

	
	
	@Override
	public List<Vehicle> findAll() {
		return jdbcTemplate.query("select * from vehicles", new VehicleRowMapper());
	}
	

	@Override
	public Vehicle findById(long id) {
		try {
			return jdbcTemplate.queryForObject("select * from vehicles where vehicle_id=?", new Object[] { id },
					new BeanPropertyRowMapper<Vehicle>(Vehicle.class));
		} catch(Exception e) {
			return null;
		}
	}
	

	@Override
	public List<Vehicle> findByBrand(String brand) {
		return jdbcTemplate.query("select * from vehicles where brand like ?", new Object[] { brand },new VehicleRowMapper());
	}
	
	@Override
	public List<Vehicle> findByModel(String model) {
		return jdbcTemplate.query("select * from vehicles where model like ?", new Object[] { model },new VehicleRowMapper());
	}
	
	@Override
	public List<Vehicle> findBySpeed(int speed) {
		return jdbcTemplate.query("select * from vehicles where speed=?", new Object[] { speed },new VehicleRowMapper());
	}
	
	@Override
	public List<Vehicle> findByType(String type) {
		return jdbcTemplate.query("select * from vehicles where type like ?", new Object[] { type },new VehicleRowMapper());
	}
	
	@Override
	public List<Vehicle> findByDescription(String description) {
		return jdbcTemplate.query("select * from vehicles where description like ?", new Object[] { description },new VehicleRowMapper());
	}
	
	
	@Override
	public List<Vehicle> findByYear(int year) {
		return jdbcTemplate.query("select * from vehicles where year = ?", new Object[] { year },new VehicleRowMapper());
	}

	@Override
	public boolean insertVehicle(Vehicle vehicle) {
		try {
			String query = "insert into vehicles(brand, model, year, speed, type, description) values(?, ?, ?, ?, ?, ?)";
			jdbcTemplate.update(query,
					new Object[] { vehicle.getBrand(), vehicle.getModel(), vehicle.getYear(), vehicle.getSpeed(), vehicle.getType(), vehicle.getDescription() });
			return true;
		} catch(Error e) {
			return false;
		}
	}

	@Override
	public boolean updateVehicle(Vehicle vehicle) {
		try {
			String query = "update vehicles set brand = ?, model = ?, year = ?, speed = ?, type = ?, description = ? where vehicle_id = ?";
			jdbcTemplate.update(query,
					new Object[] { vehicle.getBrand(), vehicle.getModel(), vehicle.getYear(), vehicle.getSpeed(), vehicle.getType(), vehicle.getDescription(),  vehicle.getVehicle_id() });
			return true;
		} catch(Error e) {
			return false;
		}
	}

	@Override
	public boolean deleteVehicle(long id) {
		try {
			jdbcTemplate.update("delete from vehicles where vehicle_id=?", new Object[] { id });
			return true;
		} catch(Error e) {
			return false;
		}
	}

	
	
}
