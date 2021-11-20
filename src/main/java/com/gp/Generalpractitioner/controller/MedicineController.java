package com.gp.Generalpractitioner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;

import com.gp.Generalpractitioner.controller.dto.MedicineDTO;

import com.gp.Generalpractitioner.service.MedicineService;

@Controller
public class MedicineController {

	private MedicineService medicineService;

	@Autowired
	public void setMedicineService(MedicineService medicineService) {
		this.medicineService = medicineService;
	}

	@RequestMapping(value = "admin/findMedicine")
	public ModelAndView findMedicine() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("medicineDTO", new MedicineDTO());
		mav.setViewName("adminFindMedicine");
		return mav;
	}

	@RequestMapping(value = "admin/findMedicineByActiveIngredient")
	public ModelAndView showMedicinesByActiveIngredient(@ModelAttribute("medicineDTO") MedicineDTO medicineDTO) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("activeIngredient", medicineDTO.getActiveIngredient());
		mav.addObject("medicines", medicineService.findMedicinesByActiveIngredient(medicineDTO.getActiveIngredient()));
		mav.setViewName("adminListMedicines");
		return mav;
	}

}
