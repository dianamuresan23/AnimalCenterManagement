package model;

import java.io.Serializable;

public class Animal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idNo;
	private String name;
	private String species;
	private String foodType;
	private String locomotion;
	private String symptoms;
	private String diagnosis;
	private String treatment;
	private String docCode;
	
	
	public Animal(String idNo,String name, String species, String foodType, String locomotion, String symptoms, String diagnosis,
			String treatment, String docCode) {
		super();
		this.idNo=idNo;
		this.name = name;
		this.species = species;
		this.foodType = foodType;
		this.locomotion = locomotion;
		this.symptoms = symptoms;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.docCode = docCode;
	}
	
    
	public String getIdNo() {
		return idNo;
	}


	public void setIdNo(String idNo) {
		this.idNo = idNo;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getLocomotion() {
		return locomotion;
	}

	public void setLocomotion(String locomotion) {
		this.locomotion = locomotion;
	}

	public String getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getTreatment() {
		return treatment;
	}

	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}

	public String getDocCode() {
		return docCode;
	}

	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}

	public String getCriterion(String criterion)
	{
		
		switch(criterion.toUpperCase()) {
		case("SPECIE"):
			return this.getSpecies();
		case("TIP ALIMENTATIE"):
			return this.getFoodType();
		case("TIP LOCOMOTIE"):
			return this.getLocomotion();
		case("SIMPTOME"):
			return this.getSymptoms();
		case("DIAGNOSTIC"):
			return this.getDiagnosis();
		case("TRATAMENT"):
			return this.getTreatment();
		case("NUME"):
			return this.getName();
		case("DOC CODE"):
			return this.getDocCode();
		default:
			return "Error";
			
			
		}
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diagnosis == null) ? 0 : diagnosis.hashCode());
		result = prime * result + ((docCode == null) ? 0 : docCode.hashCode());
		result = prime * result + ((foodType == null) ? 0 : foodType.hashCode());
		result = prime * result + ((idNo == null) ? 0 : idNo.hashCode());
		result = prime * result + ((locomotion == null) ? 0 : locomotion.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((species == null) ? 0 : species.hashCode());
		result = prime * result + ((symptoms == null) ? 0 : symptoms.hashCode());
		result = prime * result + ((treatment == null) ? 0 : treatment.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animal other = (Animal) obj;
		if (diagnosis == null) {
			if (other.diagnosis != null)
				return false;
		} else if (!diagnosis.equals(other.diagnosis))
			return false;
		if (docCode == null) {
			if (other.docCode != null)
				return false;
		} else if (!docCode.equals(other.docCode))
			return false;
		if (foodType == null) {
			if (other.foodType != null)
				return false;
		} else if (!foodType.equals(other.foodType))
			return false;
		if (idNo == null) {
			if (other.idNo != null)
				return false;
		} else if (!idNo.equals(other.idNo))
			return false;
		if (locomotion == null) {
			if (other.locomotion != null)
				return false;
		} else if (!locomotion.equals(other.locomotion))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (species == null) {
			if (other.species != null)
				return false;
		} else if (!species.equals(other.species))
			return false;
		if (symptoms == null) {
			if (other.symptoms != null)
				return false;
		} else if (!symptoms.equals(other.symptoms))
			return false;
		if (treatment == null) {
			if (other.treatment != null)
				return false;
		} else if (!treatment.equals(other.treatment))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return  idNo+","+name+","+ species+","  + foodType+","  + locomotion+","
				 + symptoms+","  + diagnosis+","  + treatment+"," 
				+ docCode ;
	}
	
	
	
}
