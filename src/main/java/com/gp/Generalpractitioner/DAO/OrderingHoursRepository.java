package com.gp.Generalpractitioner.DAO;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.Generalpractitioner.Model.OrderingHours;

public interface OrderingHoursRepository extends JpaRepository<OrderingHours, Integer> {
	
	List<OrderingHours> findAll();

	void save(Optional<OrderingHours> oh);
	
	

}
