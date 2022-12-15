package oop.flighReservationSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import oop.flighReservationSystem.entities.Plane;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, Integer>{

}
