package com.gp.Generalpractitioner.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gp.Generalpractitioner.model.Medicine;

@Repository
public interface MedicineRepository extends CrudRepository<Medicine, Integer>{
	
	public List<Medicine> findByActiveIngredient(String activeIngredient);
}
