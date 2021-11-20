package com.gp.Generalpractitioner.controller.dto;

public class MedicineDTO {
	
	private Integer idMedicine;
	private String name;
	private String activeIngredient;
	private boolean prescription;
	
	public Integer getIdMedicine() {
		return idMedicine;
	}
	
	public void setIdMedicine(Integer idMedicine) {
		this.idMedicine = idMedicine;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getActiveIngredient() {
		return activeIngredient;
	}
	
	public void setActiveIngredient(String activeIngredient) {
		this.activeIngredient = activeIngredient;
	}
	
	public boolean isPrescription() {
		return prescription;
	}
	
	public void setPrescription(boolean prescription) {
		this.prescription = prescription;
	}
	
	public MedicineDTO(Integer idMedicine, String name, String activeIngredient, boolean prescription) {
		super();
		this.idMedicine = idMedicine;
		this.name = name;
		this.activeIngredient = activeIngredient;
		this.prescription = prescription;
	}
	
	public MedicineDTO() {
	}
}
