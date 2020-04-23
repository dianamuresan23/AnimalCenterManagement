package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class WorkSchedule implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int[]  startHours= {0,0,0,0,0};
	private int[] endHours= {0,0,0,0,0};
	
	
	
	public WorkSchedule()
	{
		super();
		
	}
	public void setStartEndHours(ArrayList<String[]> inputs)
	{
		for (int i=0;i<inputs.size();i++)
		{
			if (inputs.get(i)[1].isEmpty())
				startHours[i]=0;
			else
				startHours[i]=Integer.parseInt(inputs.get(i)[1]);
			if (inputs.get(i)[2].isEmpty())
				endHours[i]=0;
			else
				endHours[i]=Integer.parseInt(inputs.get(i)[2]);
			
		}
	}
	public boolean checkWorkSchedule(Date date)
	{
		if (date.getHours() >= startHours[date.getDay()-1] && date.getHours() < endHours[date.getDay()-1])
			return true;
		return false;
	}
	
	public int[] getStartHours() {
		return startHours;
	}
	public void setStartHours(int[] startHours) {
		this.startHours = startHours;
	}
	public int[] getEndHours() {
		return endHours;
	}
	public void setEndHours(int[] endHours) {
		this.endHours = endHours;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(endHours);
		result = prime * result + Arrays.hashCode(startHours);
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
		WorkSchedule other = (WorkSchedule) obj;
		if (!Arrays.equals(endHours, other.endHours))
			return false;
		if (!Arrays.equals(startHours, other.startHours))
			return false;
		return true;
	}
	
	
	
	
	

}
