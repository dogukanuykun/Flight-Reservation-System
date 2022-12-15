package oop.flighReservationSystem.api;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;

public interface BaseController<T> {
	
	public List<T> getAll();
	public ResponseEntity<T> getById(int id);
	public T create(T t);
	public ResponseEntity<T> updateById(int id, T t);
	public ResponseEntity<Map<String, Boolean>> deleteById(int id);

}
