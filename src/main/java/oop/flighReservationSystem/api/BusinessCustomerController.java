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

import oop.flighReservationSystem.entities.BusinessClassCustomer;
import oop.flighReservationSystem.exception.ResourceNotFoundException;
import oop.flighReservationSystem.repository.BusinessClassRepository;

@RestController
@RequestMapping("/api/business_class")
public class BusinessCustomerController implements CustomerController<BusinessClassCustomer>{
	
	private BusinessClassRepository businessClassRepository;
	
	@Autowired 
	public BusinessCustomerController(BusinessClassRepository businessClassRepository) {
		this.businessClassRepository = businessClassRepository;
	}
	

	@Override
	@GetMapping("/getAll")
	public List<BusinessClassCustomer> getAll() {
		// TODO Auto-generated method stub
		return businessClassRepository.findAll();
	}

	@Override
	@GetMapping("/{id}")
	public ResponseEntity<BusinessClassCustomer> getById(@PathVariable int id) {
		// TODO Auto-generated method stub
		BusinessClassCustomer businessClassCustomer = 
				businessClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		return ResponseEntity.ok(businessClassCustomer);	
	}

	@Override
	@PostMapping("/create")
	public BusinessClassCustomer create(@RequestBody BusinessClassCustomer bcc) {
		// TODO Auto-generated method stub
		return businessClassRepository.save(bcc);
	}

	@Override
	@PutMapping("/{id}")
	public ResponseEntity<BusinessClassCustomer> updateById(@PathVariable int id, @RequestBody BusinessClassCustomer bcc) {
		// TODO Auto-generated method stub
		BusinessClassCustomer businessClassCustomer = businessClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		businessClassCustomer.setFirstName(bcc.getFirstName());
		businessClassCustomer.setLastName(bcc.getLastName());
		businessClassCustomer.setPlaneName(bcc.getPlaneName());
		
		BusinessClassCustomer updatedBCC = businessClassRepository.save(businessClassCustomer);
		return ResponseEntity.ok(updatedBCC);
	}

	@Override
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteById(@PathVariable int id) {
		// TODO Auto-generated method stub
		BusinessClassCustomer businessClassCustomer = businessClassRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Customer does not exist with id: "+id));
		businessClassRepository.delete(businessClassCustomer);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

}
