package com.gp.Generalpractitioner.service;

import java.util.List;

import com.gp.Generalpractitioner.model.Medicine;

public interface MedicineService {
	
	public List<Medicine> findMedicinesByActiveIngredient(String activeIngredient);
}
