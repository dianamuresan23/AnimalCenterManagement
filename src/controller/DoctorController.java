package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import model.Animal;
import model.PersistenceFactory;
import model.UserAccount;
import model.UserAccountPersistence;
import model.WorkSchedule;

import model.Persistence;
import model.AnimalPersistence;
import model.AnimalStatistics;
import model.AnimalStatisticsBuilder;
import model.Appointment;
import model.AppointmentPersistence;

import view.DoctorView;

public class DoctorController {
	private DoctorView docView;
	private String docCode;
	private PersistenceFactory persistenceFactory;
	private Persistence persistenceAnimals;
	private Persistence persistenceUserAccounts;
	private Persistence persistenceAppointments;
	
	public DoctorController(DoctorView docView,PersistenceFactory persistenceFactory,String docCode)
	{
		this.docView=docView;
		this.docCode=docCode;
		this.persistenceFactory=persistenceFactory;
		this.persistenceAnimals=this.persistenceFactory.getPersistence("Animal");
		this.persistenceUserAccounts=this.persistenceFactory.getPersistence("Cont Utilizator");
		this.persistenceAppointments=this.persistenceFactory.getPersistence("Programare");
		this.docView.addFilterListener(new FilterAnimalsListener());
		this.docView.addViewAllListener(new ViewAllAnimalsListener());
		this.docView.addUpdateListener(new UpdateAnimalListener());
		this.docView.addStatisticsListener(new StatisticsListener());
		this.docView.addWorkScheduleListener(new WorkScheduleListener());
		this.docView.addViewAppointmentsListener(new AppointmentsListener());
		setWorkSchedule();
		
	}
	
	public void setWorkSchedule()
	{
		UserAccount user=((UserAccountPersistence)persistenceUserAccounts).searchByCode(docCode);
		if (user.getUser().getWorkSchedule()!=null)
			docView.setWorkSchedule(user.getUser().getWorkSchedule().getStartHours(), user.getUser().getWorkSchedule().getEndHours());
	}
	
	class FilterAnimalsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String selectedValue =docView.getFilterComboBox().getSelectedItem().toString();
			if (e.getSource()==docView.getFilterButton()) {
				
				String info=docView.getFilterTexField();
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).filterByDoctorId(selectedValue, info,docCode);
				if (animals.size()>0)
				{
					viewAllAnimals(animals);
				}	
				else 
					docView.showMessage("There is no such data!");
			}
			
			
		}
		
	}
	class ViewAllAnimalsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).getAllByDoctorId(docCode);
			if (animals.size()>0)
			{
				viewAllAnimals(animals);
			}
			else
			{
				docView.showMessage("There are no animals!");
			}
			
		}
		
	}
	class UpdateAnimalListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] values=docView.getRowData(); 
			String[] newValues=docView.getUpdateData();
			Animal animal=new Animal(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]);
			if (!newValues[0].isEmpty())
				values[5]=newValues[0];
			if (!newValues[1].isEmpty())
				values[6]=newValues[1];
			if (!newValues[2].isEmpty())
				values[7]=newValues[2];
			Animal newAnimal=new Animal(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]);
		
			boolean updated=((AnimalPersistence)persistenceAnimals).update(animal, newAnimal);
			if (updated==true)
			{
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).getAllByDoctorId(docCode);	
				viewAllAnimals(animals);
			}
			else
			{
				docView.showMessage("Could not update!");
			}
			
		}
		
	}
	class StatisticsListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String selectedValue =docView.getStatisticsComboBox().getSelectedItem().toString();			
			if (e.getSource()==docView.getStatisticsButton()) {
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).getAllByDoctorId(docCode);
				if (animals.size()>0)
				{
					AnimalStatisticsBuilder animalStatisticsBuilder=new AnimalStatisticsBuilder();
					AnimalStatistics stat=animalStatisticsBuilder.createAnimalStatistics(animals);
				
					HashMap<String,Integer> statMap=new HashMap<String,Integer>();
					statMap=stat.getStatistics(selectedValue);
				
					String[] keysArray = new String[statMap.keySet().size()];
					keysArray =statMap.keySet().toArray(keysArray);
					Integer[] valsArray = new Integer[statMap.values().size()];
					valsArray =statMap.values().toArray(valsArray);
					docView.pieChart(keysArray, valsArray,selectedValue);
				}
				else
				{
					docView.showMessage("There are no animals!");
				}
			}
		}
		
	}
	class WorkScheduleListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<String[]> schedule=docView.getWorkScheduleData();
			WorkSchedule workSchedule=new WorkSchedule();
			workSchedule.setStartEndHours(schedule);
			((UserAccountPersistence)persistenceUserAccounts).updateWorkSchedule(docCode,workSchedule);
			setWorkSchedule();
			
		}
		
	}
	class AppointmentsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<Appointment> appointments=((AppointmentPersistence)persistenceAppointments).getAppointmentsByDocCode(docCode);
			if (appointments.size()>0)
				viewAppointments(appointments);
			else 
				{
				docView.showMessage("There are no appointments!");
			
				}
			
		}
		
	}
	public void viewAllAnimals(ArrayList<Animal> animals)
	{
		
		String[] columns= {"Id","Nume", "Specie","Tip Alimentatie","Tip Locomotie","Simptome","Diagnostic","Tratament","Cod Doctor"};
		Object [][] data=new Object[20][20];
	
		for (int i=0;i<animals.size();i++)
		{
			data[i][0]=(Object)animals.get(i).getIdNo();
			data[i][1]=(Object)animals.get(i).getName();
			data[i][2]=(Object)animals.get(i).getSpecies();
			data[i][3]=(Object)animals.get(i).getFoodType();
			data[i][4]=(Object)animals.get(i).getLocomotion();
			data[i][5]=(Object)animals.get(i).getSymptoms();
			data[i][6]=(Object)animals.get(i).getDiagnosis();
			data[i][7]=(Object)animals.get(i).getTreatment();
			data[i][8]=(Object)animals.get(i).getDocCode();
			
		}
	    docView.viewAll(columns,data);
	    
	}
	
	public void viewAppointments(ArrayList<Appointment> appointments)
	{
		String[] columns= {"Id Animal","Info","Data"};
		Object [][] data=new Object[20][20];
		if (appointments!=null)
		for (int i=0;i<appointments.size();i++)
		{
			data[i][0]=(Object)appointments.get(i).getIdAnimal();
			data[i][1]=(Object)appointments.get(i).getInfo();
			data[i][2]=(Object)appointments.get(i).getDate();
			
		}
		docView.viewAll(columns,data);
		
	}
	
	
	

}
