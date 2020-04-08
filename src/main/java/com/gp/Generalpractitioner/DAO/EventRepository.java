package com.gp.Generalpractitioner.DAO;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gp.Generalpractitioner.Model.Event;


public interface EventRepository extends JpaRepository<Event, Integer>{
	
	List<Event> findAll();
	
	List<Event> findAllByDate(Date date);
	
	//Event findByDescription(String description);

}
