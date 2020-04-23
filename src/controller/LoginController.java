package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import view.AdminView;

import view.DoctorView;

import view.EmployeeView;
import view.LoginView;
import model.UserAccount;
import model.PersistenceFactory;
import model.Persistence;
import model.UserAccountPersistence;


public class LoginController {
	private LoginView loginView;
	private PersistenceFactory persistenceFactory;
	private Persistence persistenceAccounts;
	
	public LoginController(LoginView loginView, PersistenceFactory persistenceFactory)
	{
		this.loginView=loginView;
		this.loginView.addLoginListener(new LoginListener());
		this.persistenceFactory=persistenceFactory;
		this.persistenceAccounts=this.persistenceFactory.getPersistence("Cont Utilizator");

	}
	class LoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			
				String user=loginView.getUser();
				String pass=loginView.getPass();
				
				UserAccount account=((UserAccountPersistence)persistenceAccounts).searchByUsername(user);
				
				
				if (account==null)
					loginView.showMessage("Invalid username or password!");
				
				else 
				if (account.getPassword().equals(pass))
					switch(account.getUser().getRole().toUpperCase())
					{
					case("DOCTOR"):
						DoctorView docView=new DoctorView();
						DoctorController docController=new DoctorController(docView,persistenceFactory,account.getUser().getCode());
						break;
					case("ANGAJAT"):
						EmployeeView empView=new EmployeeView();
						EmployeeController empController=new EmployeeController(empView,persistenceFactory);
						break;
					case("ADMINISTRATOR"):
						AdminView adminView=new AdminView();
						AdminController adminController=new AdminController(adminView,persistenceFactory);
						break;
					}
				else
					{
					     loginView.showMessage("Invalid username or password!");	
					}	
				
		}
	}


}
