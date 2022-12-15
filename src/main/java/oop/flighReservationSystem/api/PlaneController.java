package oop.flighReservationSystem.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import oop.flighReservationSystem.entities.Plane;
import oop.flighReservationSystem.exception.ResourceNotFoundException;
import oop.flighReservationSystem.repository.PlaneRepository;

@RestController
@RequestMapping("/api/plane")
public class PlaneController implements BaseController<Plane>{
	
	private PlaneRepository planeRepository;
	
	@Autowired
	public PlaneController(PlaneRepository planeRepository) {
		this.planeRepository = planeRepository;
	}

	@Override
	@GetMapping("/getAll")
	public List<Plane> getAll() {
		// TODO Auto-generated method stub
		return planeRepository.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<Plane> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		Plane plane = planeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Plane does not exist with id: "+id));
		return ResponseEntity.ok(plane);
	}

	@Override
	@PostMapping("/create")
	public Plane create(@RequestBody Plane plane) {
		// TODO Auto-generated method stub
		return planeRepository.save(plane);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<Plane> updateById(@PathVariable int id, @RequestBody  Plane p) {
		// TODO Auto-generated method stub
		Plane plane = planeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Plane does not exist with id: "+id));
		plane.setPlaneName(p.getPlaneName());
		plane.setFlightTime(p.getFlightTime());
		Plane updatedPlane = planeRepository.save(plane);
		return ResponseEntity.ok(updatedPlane);
	}


	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(int id) {
		// TODO Auto-generated method stub
		Plane plane = planeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Plane does not exist with id: "+id));
		planeRepository.delete(plane);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
