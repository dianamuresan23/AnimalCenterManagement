package model;

import java.util.ArrayList;
import java.util.Date;

public class AppointmentPersistence extends Persistence{
	public AppointmentPersistence(String fileName)
	{
		this.setFileName(fileName);
	}
	
	public ArrayList<Appointment> load()
	{
		ArrayList<Appointment> appointments = deserialize();
		return appointments;
		
	}
	
	public void save(ArrayList<Appointment> appointments)
	{
	     serialize(appointments);
	}
	public boolean delete(int index)
	{
		ArrayList<Appointment> appointments=load();
		boolean deleted=false;
		try {
			Appointment a=null;
			a=appointments.remove(index);
			if (a!=null)
				deleted=true;
			save(appointments);
		} catch(Exception e)
		{
			System.out.println("Could not delete appointment!");
		}
		
		return deleted;
		
	}
	public ArrayList<Appointment> getAppointmentsByDocCode(String docCode)
	{
		ArrayList<Appointment> appointments=load();
		ArrayList<Appointment> filtered=new ArrayList<Appointment>();
		for (Appointment a : appointments)
		{
			if (a.getDocCode().equals(docCode))
				filtered.add(a);
		}
		return filtered;
	}
	public ArrayList<Appointment> getAppointmentsByDate(Date date)
	{
		ArrayList<Appointment> appointments=load();
		ArrayList<Appointment> filtered=new ArrayList<Appointment>();
		for (Appointment a : appointments)
		{
			if (a.getDate().getYear()==date.getYear()  && a.getDate().getMonth()==date.getMonth() && a.getDate().getDate()==date.getDate())
				filtered.add(a);
		}
		return filtered;
	}
	public ArrayList<Integer> getAppointmentsByDateAndDocCode(String docCode, Date date)
	{
		ArrayList<Appointment> appointments=load();
		ArrayList<Integer> filtered=new ArrayList<Integer>();
		for (Appointment a : appointments)
		{
			if (a.getDate().getYear()==date.getYear()  && a.getDate().getMonth()==date.getMonth() 
					&& a.getDate().getDate()==date.getDate() && a.getDocCode().equals(docCode))
				filtered.add(a.getDate().getHours());
		}
		return filtered;
	}
	public boolean addAppointment(Appointment appointment)
	{
		boolean added=false;
		ArrayList<Appointment> appointments=load();
		try {
			added=appointments.add(appointment);
			save(appointments);
		}catch(Exception e)
		{
			System.out.println("Could not add appointment");
		}
		
		return added;
	}
	
	public void deleteByDocCode(String docCode)
	{
		ArrayList<Appointment> appointments=load();
		ArrayList<Appointment> newAppointments=new ArrayList<Appointment>();
		for (Appointment a:appointments)
				if(!a.getDocCode().equals(docCode))
					newAppointments.add(a);
		save(newAppointments);
		
	}
	public void deleteByAnimalId(String animalId)
	{
		ArrayList<Appointment> appointments=load();
		ArrayList<Appointment> newAppointments=new ArrayList<Appointment>();
		for (Appointment a:appointments)
				if(!a.getIdAnimal().equals(animalId))
					newAppointments.add(a);
		save(newAppointments);
		
	}
}
