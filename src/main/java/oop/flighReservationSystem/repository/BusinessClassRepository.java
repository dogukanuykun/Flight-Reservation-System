package oop.flighReservationSystem.repository;



import org.springframework.stereotype.Repository;

import oop.flighReservationSystem.entities.BusinessClassCustomer;

@Repository
public interface BusinessClassRepository extends CustomerRepository<BusinessClassCustomer>{

}
