package oop.flighReservationSystem.repository;



import org.springframework.stereotype.Repository;

import oop.flighReservationSystem.entities.FirstClassCustomer;

@Repository
public interface FirstClassRepository extends CustomerRepository<FirstClassCustomer>{

}
