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
		
		/*
		Animal a=new Animal("09821","Zara","caine","carnivor","patruped","-","-","-","1235");
		Animal b=new Animal("87219","Sandy","pisica","carnivor","patruped","-","-","-","1235");
		Animal c=new Animal("97163","Loki","caine","carnivor","patruped","-","-","-","1235");
		Animal d=new Animal("87217","Tiki","iepure","erbivor","patruped","-","-","-","1235");
		Animal f=new Animal("19318","Miki","iepure","erbivor","patruped","-","-","-","1235");
		ArrayList<Animal> animale=new ArrayList<Animal>();
		animale.add(a);
		animale.add(b);
		animale.add(c);
		animale.add(d);
		animale.add(f);
		
		AnimalPersistence pers=new AnimalPersistence("animale.ser");
		pers.save(animale);*/
	
		/*UserAccountPersistence persis=new UserAccountPersistence("conturi.ser");
		UserPersistence persisUtil=new UserPersistence("utilizatori.ser");
		User utilizator=new User("Diana",21,"1234","angajat");
		UserAccount cont=new UserAccount(utilizator,"ang","1223");
		User utilizator1=new User("Ioana",21,"1235","doctor");
		UserAccount cont1=new UserAccount(utilizator1,"doc","9999");
		User utilizator2=new User("Denisa",15,"1236","administrator");
		UserAccount cont2=new UserAccount(utilizator2,"admin","0000");
		ArrayList<UserAccount> conturi=new ArrayList<UserAccount>();
		ArrayList<User> utilizatori=new ArrayList<User>();
		conturi.add(cont);
		conturi.add(cont1);
		conturi.add(cont2);
		utilizatori.add(utilizator);
		utilizatori.add(utilizator1);
		utilizatori.add(utilizator2);
		persis.save(conturi);
		*/
		
		
		

		
		
		

	}

}
