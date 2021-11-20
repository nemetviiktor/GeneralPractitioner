package com.gp.Generalpractitioner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@Column(name="medicine_id")
	private Integer idMedicine;
	
	@Column(name="name")
	private String name;
	
	@Column(name="active_ingredient")
	private String activeIngredient;
	
	@Column(name="prescription")
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
}
