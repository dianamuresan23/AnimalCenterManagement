package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;


import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.orsoncharts.util.json.JSONObject;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import model.Animal;
import model.UserAccount;
import model.PersistenceFactory;
import model.Persistence;
import model.AnimalPersistence;
import model.UserAccountPersistence;

import model.AnimalStatistics;
import model.AnimalStatisticsBuilder;
import model.Appointment;
import model.AppointmentPersistence;

import view.EmployeeView;

public class EmployeeController {
	private EmployeeView empView;
	private PersistenceFactory persistenceFactory;
	private Persistence persistenceAnimals;
	private Persistence persistenceAccounts;
	private Persistence persistenceAppointments;
	
	public EmployeeController(EmployeeView view, PersistenceFactory persistenceFactory)
	{
		this.empView=view;
	    this.persistenceAnimals=persistenceFactory.getPersistence("Animal");
	    this.persistenceAccounts=persistenceFactory.getPersistence("Cont Utilizator");
	    this.persistenceAppointments=persistenceFactory.getPersistence("Programare");
		this.empView.addAddListener(new AddAnimalListener());
		this.empView.addViewAllListener(new ViewAllAnimalsListener());
		this.empView.addFilterListener(new FilterAnimalsListener());
		this.empView.addDeleteListener(new DeleteAnimalListener());
		this.empView.addUpdateListener(new UpdateAnimalListener());
		this.empView.addStatisticsListener(new StatisticsListener());
		this.empView.addCheckListener(new MakeAppointmentListener());
		this.empView.addViewAppointmentsListener(new ViewAppointmentsListener());
		this.empView.addDeleteAppointmentListener(new DeleteAppointmentListener());
		this.empView.addSaveReportsListener(new SaveReportsListener());
	

	}

	class AddAnimalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{ 
		       ArrayList<String> inputs= empView.getAddUserInput();
		       Animal a =((AnimalPersistence)persistenceAnimals).searchById(inputs.get(0));
		       if (a!=null)
		    	   empView.showMessage("There is an animal with this id!");
		       else
		       {
		       Animal animal=new Animal(inputs.get(0),inputs.get(1),inputs.get(2),inputs.get(3),inputs.get(4),inputs.get(5),inputs.get(6),inputs.get(7),inputs.get(8));
		       boolean added=((AnimalPersistence)persistenceAnimals).add(animal);
		       if (added==false)
		    	   empView.showMessage("Could not add animal!");
		       else 
		    	   {
		    	    ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).load();
		    	   	viewAllAnimals(animals);
		    	    empView.showMessage("Animal added successfully!");
		    	   }
		       }
		       
		}
	}
	
	class ViewAllAnimalsListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).load();
			if (animals.size()>0)
			{
				viewAllAnimals(animals); 
			}
			else
			{
			
				empView.showMessage("There are no animals!");
				viewAllAnimals(null);
			}
		}
	}
	class FilterAnimalsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				
			String selectedValue =empView.getFilterComboBox().getSelectedItem().toString();	
			if (e.getSource()==empView.getFilterButton()) {
				String info=empView.getFilterTextField();
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).filter(selectedValue, info);
				if (animals.size()>0)
				{
					viewAllAnimals(animals);
				}	
				else 
					empView.showMessage("There is no such data!");
			}
			
		}
		
	}
	class SaveReportsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
				String selectedValue =empView.getFilterComboBox().getSelectedItem().toString();	
				String info=empView.getFilterTextField();
				if (e.getSource()==empView.getSaveReportsButton()) {
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).filter(selectedValue, info);
				if (animals.size()>0) {
				String newLine="\n";
				String header="Nume,Specie,Tip alimentatie,Tip locomotie,Simptome,Diagnostic,Tratament,Cod doctor";
				try {
					
					  	DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			            Document document = documentBuilder.newDocument();
			            Element root = document.createElement("Animale");
			            document.appendChild(root);
					
					FileWriter fileWriter=new FileWriter("listAnimals.csv");
					FileWriter fileWriterJ=new FileWriter("listAnimals.json");
					fileWriter.append(header);
					for(Animal animal: animals)
					{
			            Element animalX = document.createElement("Animal");
			            root.appendChild(animalX);
			            Element name = document.createElement("Nume");
			            name.appendChild(document.createTextNode(animal.getName()));
			            animalX.appendChild(name);
			 
			            Element species = document.createElement("Specie");
			            species.appendChild(document.createTextNode(animal.getSpecies()));
			            animalX.appendChild(species);

			            Element foodType = document.createElement("TipAlimentatie");
			            foodType.appendChild(document.createTextNode(animal.getFoodType()));
			            animalX.appendChild(foodType);

			            Element locomotion = document.createElement("TipLocomotie");
			            locomotion.appendChild(document.createTextNode(animal.getLocomotion()));
			            animalX.appendChild(locomotion);
			            
			            Element symptoms= document.createElement("Simptome");
			            symptoms.appendChild(document.createTextNode(animal.getSymptoms()));
			            animalX.appendChild(symptoms);
			            
			            Element diagnosis = document.createElement("Diagnostic");
			            diagnosis.appendChild(document.createTextNode(animal.getDiagnosis()));
			            animalX.appendChild(diagnosis);
			            
			            Element treatment = document.createElement("Tratament");
			            treatment.appendChild(document.createTextNode(animal.getTreatment()));
			            animalX.appendChild(treatment);
			            
			            Element docCode = document.createElement("CodDoctor");
			            docCode.appendChild(document.createTextNode(animal.getDocCode()));
			            animalX.appendChild(docCode);
						
						
						JSONObject j=new JSONObject();
						j.put("Nume",animal.getName());
						j.put("Specie",animal.getSpecies());
						j.put("Tip alimentatie",animal.getFoodType());
						j.put("Tip Locomotie",animal.getLocomotion());
						j.put("Simptome",animal.getSymptoms());
						j.put("Diagnostic",animal.getDiagnosis());
						j.put("Tratament",animal.getTreatment());
						j.put("Cod Doctor",animal.getDocCode());
						
						fileWriterJ.append(j.toJSONString());
						fileWriterJ.append(newLine);
						
						
						
						fileWriter.append(newLine);
						fileWriter.append(animal.toString());
						
					}
					 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			            Transformer transformer = transformerFactory.newTransformer();
			            DOMSource domSource = new DOMSource(document);
			            StreamResult streamResult = new StreamResult(new File("listAnimals.xml"));
			            transformer.transform(domSource, streamResult);
			            
					fileWriter.flush();
					fileWriter.close();
					fileWriterJ.flush();
					fileWriterJ.close();
				}
				catch (IOException exc)
				{
					System.out.println(exc.getMessage());
				
				}  catch (ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TransformerConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (TransformerException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				}
				else
				{
					empView.showMessage("There is no such data!");
				}
				}
				
               
              
			
		}
		
	}
	class DeleteAnimalListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index=empView.getSelectedRow();
			String[] values=empView.getRowData();
			boolean deleted=((AnimalPersistence)persistenceAnimals).delete(index);
			if (deleted==true)
			{
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).load();
				viewAllAnimals(animals);
				((AppointmentPersistence)persistenceAppointments).deleteByAnimalId(values[0]);
				
			}
			else
			{
				empView.showMessage("Could not delete animal!");
			}
			
		}
		
	}
	
	class UpdateAnimalListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			String[] values=empView.getRowData();
			String[] new_values=empView.getUpdateData();
			Animal animal=new Animal(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]);
			if (!new_values[0].isEmpty())
			{
				Animal a=((AnimalPersistence)persistenceAnimals).searchById(new_values[0]);
				if (a!=null)
				{
					empView.showMessage("There already exists an animal with this is!");
					return;
				}
				else
					values[0]=new_values[0];
			}
			if (!new_values[1].isEmpty())
				values[1]=new_values[1];
			if (!new_values[2].isEmpty())
				values[2]=new_values[2];
			if (!new_values[3].isEmpty())
				values[3]=new_values[3];
			if (!new_values[4].isEmpty())
				values[4]=new_values[4];
			if (!new_values[5].isEmpty())
				values[8]=new_values[5];
			Animal newAnimal=new Animal(values[0],values[1],values[2],values[3],values[4],values[5],values[6],values[7],values[8]);
			boolean updated=((AnimalPersistence)persistenceAnimals).update(animal, newAnimal);
			if (updated==true)
			{
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).load();
				viewAllAnimals(animals);
			}
			else
			{
				empView.showMessage("Could not update animal!");
			}
			
		}
		
	}
	
	class StatisticsListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String selectedValue =empView.getFilterComboBox().getSelectedItem().toString();			
			if (e.getSource()==empView.getStatisticsButton()) {
				ArrayList<Animal> animals=((AnimalPersistence)persistenceAnimals).load();
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
				    empView.pieChart(keysArray, valsArray,selectedValue);
				}
				else
				{
					empView.showMessage("There are no animals!");
				}
			}
		}
		
	}
	class MakeAppointmentListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int mon=transformMonth(empView.getMonthComboBox().getSelectedItem().toString());
			String day =empView.getDayComboBox().getSelectedItem().toString();	
			String hour=empView.getHourComboBox().getSelectedItem().toString();
			String ss[]=hour.split(":");
			Date date=new Date();
			date.setHours(Integer.parseInt(ss[0]));
			date.setMonth(mon);
			date.setDate(Integer.parseInt(day));
			date.setMinutes(0);
			date.setSeconds(0);
			
		
			if (e.getSource()==empView.getCheckButton())
			{
				empView.clearAvailableDoctor();
				if (date.getDay()==0 || date.getDay()==6)
					empView.addAvailableDoctor("Not a working day!");
				else 
				{
					ArrayList<UserAccount> doctors =((UserAccountPersistence)persistenceAccounts).getUsersByRole("DOCTOR");
					for (UserAccount doc:doctors)
					{
						String h=getAvailableHours(doc, date);   
						empView.addAvailableDoctor(doc.getUser().getName()+"      "+doc.getUser().getCode());
						empView.addAvailableDoctor(h);
					}
				}
				
			}
			
			if (e.getSource()==empView.getMakeAppointmentButton())
			{
				String docId=empView.getDoctorAppointment();
				UserAccount doc=((UserAccountPersistence)persistenceAccounts).searchByCode(docId);
				if(doc==null)
					empView.showMessage("Wrong doctor code!");
				else {
				String info=empView.getAppointmentInfo();
				String animalId=empView.getAnimalIdAppointment();
				Animal animal=((AnimalPersistence)persistenceAnimals).searchById(animalId);
				if (animal==null)
					empView.showMessage("Wrong animal id");
				else
				{
					if (doc.getUser().getWorkSchedule().checkWorkSchedule(date))
					{
						if(animal.getDocCode().equals(docId))
						{
						Appointment appointment=new Appointment( animalId,docId,info, date);
						((AppointmentPersistence)persistenceAppointments).addAppointment(appointment);
						ArrayList<Appointment> appointments=((AppointmentPersistence)persistenceAppointments).load();
						viewAllAppointments(appointments);
						}
						else {
							empView.showMessage("The animal has another doctor: "+docId );
						}
					}
					else 
						empView.showMessage("Doctor is not available");
				
				}
				
			}
			
		}
		
		
	}
	}
	class ViewAppointmentsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<Appointment> appointments=((AppointmentPersistence)persistenceAppointments).load();
			if (appointments.size()>0)
				viewAllAppointments(appointments);
			else {
				empView.showMessage("There are no appoinments!");
				viewAllAppointments(null);
			}
			
		}
		
	}
	class DeleteAppointmentListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index=empView.getSelectedRowAppointment();
			boolean deleted=((AppointmentPersistence)persistenceAppointments).delete(index);
			if (deleted==true)
			{
				ArrayList<Appointment> appointments=((AppointmentPersistence)persistenceAppointments).load();
				viewAllAppointments(appointments);
			}
			else
			{
				empView.showMessage("Could not delete appointment!");
			}
		}
		
	}
	
	public void viewAllAppointments(ArrayList<Appointment> appointments)
	{
		
		String[] columns= {"Id animal","Cod Doctor","Info","Data"};
		Object [][] data=new Object[20][20];
		if(appointments!=null)
		for (int i=0;i<appointments.size();i++)
		{
			data[i][0]=(Object)appointments.get(i).getIdAnimal();
			data[i][1]=(Object)appointments.get(i).getDocCode();
			data[i][2]=(Object)appointments.get(i).getInfo();
			data[i][3]=(Object)appointments.get(i).getDate();
			
		}
		empView.viewAll2(columns,data);
	}
	public void viewAllAnimals(ArrayList<Animal> animals)
	{
		
		String[] columns= {"ID","Nume", "Specie","Tip Alimentatie","Tip Locomotie","Simptome","Diagnostic","Tratament","Cod Doctor"};
		Object [][] data=new Object[20][20];
		if (animals!=null)
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
	    empView.viewAll(columns,data);
	    
	}

	
	
	
	public int transformMonth(String month)
	{
		int mon=0;
		switch(month)
		{
		case("Ianuarie"):
			mon=0;
		break;
		case ("Februarie"):
			mon=1;
		break;
		case ("Martie"):
			mon=2;
		break;
		case ("Aprilie"):
			mon=3;
		break;
		case ("Mai"):
			mon=4;
		break;
		case ("Iunie"):
			mon=5;
		break;
		case ("Iulie"):
			mon=6;
		break;
		case ("August"):
			mon=7;
		break;
		case ("Septembrie"):
			mon=8;
		break;
		case ("Octombrie"):
			mon=9;
		break;
		case ("Noiembrie"):
			mon=10;
		break;
		case ("Decembrie"):
			mon=11;
		break;
		
		}
		return mon;
	}
	public String getAvailableHours(UserAccount doc,Date date)
	{
		String h="";
		ArrayList<Integer> apps=((AppointmentPersistence)persistenceAppointments).getAppointmentsByDateAndDocCode(doc.getUser().getCode(), date);
		for (int i=doc.getUser().getWorkSchedule().getStartHours()[date.getDay()-1];
				i<doc.getUser().getWorkSchedule().getEndHours()[date.getDay()-1]; i++)
		{
			if (apps.size()>0)
			{
				if (!apps.contains(i))
					h += i + ":00, ";
			}
			else
			{
				h+=i + ":00, ";
			}
		}
		return h;
	}
	
	}