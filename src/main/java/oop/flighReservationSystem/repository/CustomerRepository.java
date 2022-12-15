package oop.flighReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import oop.flighReservationSystem.entities.Customer;

public interface CustomerRepository<T extends Customer> extends JpaRepository<T, Integer>{

}
