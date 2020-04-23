package main;

import model.Animal;
import model.UserAccount;
import model.AnimalPersistence;
import model.PersistenceFactory;
import model.UserAccountPersistence;
import model.User;


import view.LoginView;

import java.util.ArrayList;
import java.util.Date;

import controller.LoginController;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView view =new LoginView();
		PersistenceFactory persistenceFactory=new PersistenceFactory();
		
		LoginController controller=new LoginController(view, persistenceFactory);
		
		
		
		
		

		
		
		

	}

}
