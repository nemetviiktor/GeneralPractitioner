package com.gp.Generalpractitioner.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gp.Generalpractitioner.model.Medicine;
import com.gp.Generalpractitioner.repository.MedicineRepository;

@Service
public class MedicineServiceImpl implements MedicineService {
	
	private MedicineRepository medicineRepository;

	@Autowired
	public void setMedicineRepository(MedicineRepository medicineRepository) {
		this.medicineRepository = medicineRepository;
	}

	@Override
	public List<Medicine> findMedicinesByActiveIngredient(String activeIngredient) {
		return medicineRepository.findByActiveIngredient(activeIngredient);
	}
}
