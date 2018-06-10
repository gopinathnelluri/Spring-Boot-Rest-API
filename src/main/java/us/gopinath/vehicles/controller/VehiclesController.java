package us.gopinath.vehicles.controller;

import java.util.List;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import us.gopinath.vehicles.model.Vehicle;
import us.gopinath.vehicles.reposityory.VehiclesJdbcRepository;

@RestController
public class VehiclesController {

	
	@Autowired
	private VehiclesJdbcRepository vehiclesJdbcRepository;
	
	@RequestMapping(value="/vehicles", method=RequestMethod.GET)
	public @ResponseBody Object getAllVehicles() {
		try {
			return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findAll(), HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/vehicles/{id}", method=RequestMethod.GET)
	public @ResponseBody Object getVehicleWithId(@PathVariable @NotNull @DecimalMin("0") long id) {
		try {
			Vehicle vehicle = vehiclesJdbcRepository.findById(id);
			if(vehicle != null) {
				return new ResponseEntity<Vehicle>(vehicle, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	

	@RequestMapping(value="/vehicles/{id}", method=RequestMethod.DELETE)
	public @ResponseBody Object deleteVehicleWithId(@PathVariable @NotNull @DecimalMin("0") long id) {
		try {
			if(vehiclesJdbcRepository.deleteVehicle(id)) {
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}

	
	@RequestMapping(value="/vehicles/{search}/{tag}", method=RequestMethod.GET)
	public @ResponseBody Object getVehicleWithId(@PathVariable @NotNull String search ,@PathVariable @NotNull String tag) {
		try {
			if(search.equalsIgnoreCase("brand")) {
				return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findByBrand(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("model")) {
				return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findByModel(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("speed")) {
				if(tag.chars().allMatch( Character::isDigit )) {
					int speed = Integer.parseInt(tag);
					return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findBySpeed(speed), HttpStatus.OK);
				}
			} else if(search.equalsIgnoreCase("type")) {
				return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findByType(tag), HttpStatus.OK);
			} else if(search.equalsIgnoreCase("year")) {
				if(tag.chars().allMatch( Character::isDigit )) {
					int year = Integer.parseInt(tag);
					return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findByYear(year), HttpStatus.OK);
				}
			} else if(search.equalsIgnoreCase("description")) {
				return new ResponseEntity<List<Vehicle>>(vehiclesJdbcRepository.findByDescription(tag), HttpStatus.OK);
			} 
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<Object> (null, HttpStatus.NO_CONTENT);
	}
	
	@RequestMapping(value="/vehicles", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object postVehicle(@RequestBody Vehicle vehicle) {
		try {
			if(vehiclesJdbcRepository.insertVehicle(vehicle)) {
				return new ResponseEntity<Object> (HttpStatus.OK);
			} else {
				return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/vehicles/{id}", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object postVehicle(@PathVariable @NotNull @DecimalMin("0") long id, @RequestBody Vehicle vehicle) {
		try {
			vehicle.setVehicle_id(id);
			if(vehiclesJdbcRepository.updateVehicle(vehicle)) {
				return new ResponseEntity<Object> (HttpStatus.OK);
			} else {
				return new ResponseEntity<Object> (HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value="/vehicles", method=RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Object putVehicle(@RequestBody Vehicle vehicle) {
		try {
			if(vehiclesJdbcRepository.updateVehicle(vehicle)) {
				return new ResponseEntity<Object> (HttpStatus.OK);
			} else {
				return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object> (null, HttpStatus.BAD_REQUEST);
		}
	}
}
