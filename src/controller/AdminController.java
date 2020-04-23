package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;

import model.Animal;
import model.UserAccount;
import model.PersistenceFactory;
import model.Persistence;
import model.AnimalPersistence;
import model.AppointmentPersistence;
import model.UserAccountPersistence;
import model.User;

import view.AdminView;

public class AdminController {
	private AdminView adminView;
	private PersistenceFactory persistenceFactory;
	private Persistence persistenceAccounts;
	private Persistence persistenceAnimals;
	private Persistence persistenceAppointments;
	public AdminController(AdminView adminView,PersistenceFactory persistenceFactory)
	
	{
		this.adminView=adminView;
	    this.persistenceFactory=persistenceFactory;
	    this.persistenceAccounts=persistenceFactory.getPersistence("Cont Utilizator");
	    this.persistenceAnimals=persistenceFactory.getPersistence("Animal");
	    this.persistenceAppointments=persistenceFactory.getPersistence("Programare");
	    adminView.addViewAllListener(new ViewAllUsersListener());
		adminView.addViewAllDoctorsListener(new ViewAllDoctorsListener());
		adminView.addViewAllEmployeesListener(new ViewAllEmployeesListener());
		adminView.addAddListener(new AddUserListener());
		adminView.addDeleteListener(new DeleteUserListener());
		adminView.addUpdateListener(new UpdateUserListener());
		
	}
	class ViewAllUsersListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<UserAccount> doctors=((UserAccountPersistence)persistenceAccounts).getUsersByRole("DOCTOR");
			ArrayList<UserAccount> employees=((UserAccountPersistence)persistenceAccounts).getUsersByRole("ANGAJAT");
			doctors.addAll(employees);
			if (doctors.size()>0)
				viewAllUsers(doctors);
			else adminView.showMessage("There are no users!");
		}
		
	}
	class ViewAllDoctorsListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<UserAccount> accounts=((UserAccountPersistence)persistenceAccounts).getUsersByRole("DOCTOR");
			if (accounts.size()>0)
				viewAllUsers(accounts);
			else
			{
				viewAllUsers(null);
				adminView.showMessage("There are no doctors!");
			}
		}
	}
	
	class ViewAllEmployeesListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			ArrayList<UserAccount> accounts=((UserAccountPersistence)persistenceAccounts).getUsersByRole("ANGAJAT");
			if(accounts.size()>0)
				viewAllUsers(accounts);
			else adminView.showMessage("There are no employees!");
		}
	}
	
	class AddUserListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] inputs=adminView.getUserInput();
			UserAccount acc=((UserAccountPersistence)persistenceAccounts).searchByCode(inputs[2]);
			UserAccount acc1=((UserAccountPersistence)persistenceAccounts).searchByUsername(inputs[3]);
			if (acc!=null)
				adminView.showMessage("There is a user with this code already!");
			else if(acc1!=null)
				adminView.showMessage("This username already exists!");
			else
			{
			String role=adminView.getRol();
			User user=new User(inputs[0],Integer.parseInt(inputs[1]),inputs[2], role);
			UserAccount account=new UserAccount(user, inputs[3],inputs[4]);
			boolean added=((UserAccountPersistence)persistenceAccounts).add(account);
		       if (added==false)
		    	   adminView.showMessage("Could not add user!");
		       else {
		    	   adminView.showMessage("User added successfully!");
		    	  
		       }
			}
		
		}
		
	}
	class DeleteUserListener implements ActionListener
	{
	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int index=adminView.getSelectedRow();
			String[] inputData=adminView.getRowData();
			UserAccount account=((UserAccountPersistence)persistenceAccounts).searchByUsername(inputData[4]);
			if (inputData[3].equals("DOCTOR"))
				{
				String docCode=inputData[2];
				((AnimalPersistence)persistenceAnimals).deleteByDocCode(docCode);
				((AppointmentPersistence)persistenceAppointments).deleteByDocCode(docCode);
				}
			boolean deleted=((UserAccountPersistence)persistenceAccounts).delete(account);
			if (deleted==false)
				adminView.showMessage("Could not delete user!");
			else adminView.showMessage("User deleted!");
			
		}
	}
	class UpdateUserListener implements ActionListener

	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String[] values=adminView.getRowData();  //code name age role username pass
			String[] new_values=adminView.getUserInput(); //name age code username pass
			UserAccount account=((UserAccountPersistence)persistenceAccounts).searchByUsername(values[4]);
			if (!new_values[0].isEmpty())
				values[1]=new_values[0];
			if (!new_values[1].isEmpty())
				values[2]=new_values[1];
			if (!new_values[2].isEmpty())
			{
				UserAccount u=((UserAccountPersistence)persistenceAccounts).searchByCode(new_values[2]);
				if (u!=null)
				{
					adminView.showMessage("There already exists an user with this code!");
					return;
				}
				else
					values[0]=new_values[2];
			}
				
			if (!new_values[3].isEmpty())
			{
				UserAccount u=((UserAccountPersistence)persistenceAccounts).searchByUsername(new_values[3]);
				if (u!=null)
				{
					adminView.showMessage("There already exists an user with this username!");
					return;
				}
				else
				values[4]=new_values[3];
			}
				
			if (!new_values[4].isEmpty())
				values[5]=new_values[4];
			User newUser=new User(values[1],Integer.parseInt(values[2]),values[0],values[3]);
			UserAccount newAccount=new UserAccount(newUser,values[4],values[5]);
			newAccount.getUser().setWorkSchedule(account.getUser().getWorkSchedule());
			boolean updated=((UserAccountPersistence)persistenceAccounts).update(account, newAccount);
			if (updated==false)
			{
				adminView.showMessage("Use could not be updated!");
			}
			else
			{
				adminView.showMessage("User updated!");
			}
			
		}
		
	}
	public void viewAllUsers(ArrayList<UserAccount> accounts)
	{
		String[] columns = {"Cod",
                "Nume",
                "Varsta",
                "Rol",
                "username",
                "parola"
                };
		Object [][] data=new Object[20][20];
		if (accounts!=null)
		for(int i=0;i<accounts.size();i++)
		{
			data[i][0]=accounts.get(i).getUser().getCode();
			data[i][1]=accounts.get(i).getUser().getName();
			data[i][2]=String.valueOf(accounts.get(i).getUser().getAge());
			data[i][3]=accounts.get(i).getUser().getRole();
			data[i][4]=accounts.get(i).getUsername();
			data[i][5]=accounts.get(i).getPassword();
		}	
		adminView.viewAll(columns,data);
		
	}
	
	
	
	
	
	
}
