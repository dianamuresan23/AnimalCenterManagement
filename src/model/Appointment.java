package model;

import java.io.Serializable;
import java.util.Date;

public class Appointment implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idAnimal;
	private String docCode;
    private String info;
    private Date date;
	public Appointment(String idAnimal,String docCode, String info, Date date) {
		super();
		this.idAnimal=idAnimal;
		this.docCode = docCode;
		this.info = info;
		this.date = date;
	}
	
	public String getIdAnimal() {
		return idAnimal;
	}

	public void setIdAnimal(String idAnimal) {
		this.idAnimal = idAnimal;
	}

	public String getDocCode() {
		return docCode;
	}
	public void setDocCode(String docCode) {
		this.docCode = docCode;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((docCode == null) ? 0 : docCode.hashCode());
		result = prime * result + ((idAnimal == null) ? 0 : idAnimal.hashCode());
		result = prime * result + ((info == null) ? 0 : info.hashCode());
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
		Appointment other = (Appointment) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (docCode == null) {
			if (other.docCode != null)
				return false;
		} else if (!docCode.equals(other.docCode))
			return false;
		if (idAnimal == null) {
			if (other.idAnimal != null)
				return false;
		} else if (!idAnimal.equals(other.idAnimal))
			return false;
		if (info == null) {
			if (other.info != null)
				return false;
		} else if (!info.equals(other.info))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Appointment [idAnimal=" + idAnimal + ", docCode=" + docCode + ", info=" + info + ", date=" + date + "]";
	}

	
    
	
	
	
}
