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

import oop.flighReservationSystem.entities.FirstClassCustomer;
import oop.flighReservationSystem.exception.ResourceNotFoundException;
import oop.flighReservationSystem.repository.FirstClassRepository;

@RestController
@RequestMapping("/api/first_class")
public class FirstClassCustomerController implements CustomerController<FirstClassCustomer>{
	
	private FirstClassRepository firstClassRepository;
	
	@Autowired
	public FirstClassCustomerController(FirstClassRepository firstClassRepository) {
		this.firstClassRepository = firstClassRepository;
	}

	@Override
	@GetMapping("/getAll")
	public List<FirstClassCustomer> getAll() {
		// TODO Auto-generated method stub
		return firstClassRepository.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<FirstClassCustomer> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		FirstClassCustomer firstClassCustomer = 
				firstClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		return ResponseEntity.ok(firstClassCustomer);
	}

	@Override
	@PostMapping("/create")
	public FirstClassCustomer create(@RequestBody FirstClassCustomer fcc) {
		// TODO Auto-generated method stub
		return firstClassRepository.save(fcc);
	
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<FirstClassCustomer> updateById(@PathVariable int id, @RequestBody FirstClassCustomer fc) {
		// TODO Auto-generated method stub
		FirstClassCustomer firstClassCustomer = firstClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		firstClassCustomer.setFirstName(fc.getFirstName());
		firstClassCustomer.setLastName(fc.getLastName());
		firstClassCustomer.setPlaneName(fc.getPlaneName());
		
		FirstClassCustomer updatedFC = firstClassRepository.save(firstClassCustomer);
		return ResponseEntity.ok(updatedFC);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable int id) {
		// TODO Auto-generated method stub
		FirstClassCustomer firstClassCustomer = firstClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		firstClassRepository.delete(firstClassCustomer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	
	
	
}
