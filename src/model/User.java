package model;

import java.io.Serializable;
import java.util.ArrayList;

enum Role {
	ADMINISTRATOR, 
	ANGAJAT,
	DOCTOR
}
	public class User  extends Person implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Role role;
	    private WorkSchedule workSchedule;
		
		public User(String name, int age, String code, String role)
		{
			super(name,age,code);
			setRole(role);
	   
		}
		
		public WorkSchedule getWorkSchedule()
		{
			return workSchedule;
		}
		public void setWorkSchedule(WorkSchedule workSchedule)
		{
			this.workSchedule=workSchedule;
		}
   
		public String getRole() {
			return role.toString();
		}

		public void setRole(String roleUser) {
			switch(roleUser.toUpperCase()) {
			case("ADMINISTRATOR"):
				this.role=Role.ADMINISTRATOR;
	   	   	break;
			case("ANGAJAT"):
				this.role=Role.ANGAJAT;
	   	   	break;
			case("DOCTOR"):
				this.role=Role.DOCTOR;
	   	   	break;
		  
			}
		}
		@Override
		public String toString() {
			return "User [role=" + role + ", getName()=" + getName() + ", getAge()=" + getAge() + ", getCode()="
					+ getCode() + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = super.hashCode();
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + ((workSchedule == null) ? 0 : workSchedule.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!super.equals(obj))
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			if (role != other.role)
				return false;
			if (workSchedule == null) {
				if (other.workSchedule != null)
					return false;
			} else if (!workSchedule.equals(other.workSchedule))
				return false;
			return true;
		}

		
		

}
