package model;

import java.util.ArrayList;
import java.util.Date;

public class UserAccountPersistence extends Persistence {
	
	public UserAccountPersistence(String fileName)
	{
		this.setFileName(fileName);
	}
	
	public ArrayList<UserAccount> load()
	{
		ArrayList<UserAccount> accounts = deserialize();	
		return accounts;
		
	}
	
	public void save(ArrayList<UserAccount> accounts)
	{
	     serialize(accounts);
	}
	
	public UserAccount searchByUsername(String user)
	{
		ArrayList<UserAccount> accounts=load();
		for (UserAccount account:accounts)
			if(account.getUsername().equals(user))
				return account;
		return null;
	}
	
	public ArrayList<UserAccount> getUsersByRole(String role)
	{
		ArrayList<UserAccount> accounts=load();
		ArrayList<UserAccount> users =new ArrayList<UserAccount>();
		for (UserAccount c:accounts)
			if (c.getUser().getRole().equals(role))
					users.add(c);
		return users;		
	}
	
	public boolean add(UserAccount user)
	{
		boolean added=false;
		ArrayList<UserAccount> users=load();
		try {
			added=users.add(user);
			save(users);
		}catch(Exception e)
		{
			System.out.println("Could not add user account");
		}
		
		return added;
	}
	

	
	public boolean delete(UserAccount account)
	{
		ArrayList<UserAccount> users=load();
		boolean deleted=false;
		try {
			 
			deleted=users.remove(account);
			save(users);
		} catch(Exception e)
		{
			System.out.println("Could not delete user account!");
		}
		
		return deleted;
		
	}
	public boolean update(UserAccount user, UserAccount newUser)
	{
		ArrayList<UserAccount> users=load();
		UserAccount user_aux=null;
		int index=-1;
		boolean updated=false;
	
			for (UserAccount c:users)
			{
				if (c.equals(user))
					{
				
					index=users.indexOf(c);
					break;
					}
			}
			
			if (index!=-1)
				try {
					users.set(index, newUser);
					save(users);	
					updated=true;
				}catch (Exception e)
			{
					System.out.println("Could not update user account!");
					updated=false;
			}		
				
			
		return updated;	
			
		}
	public void updateWorkSchedule(String code,WorkSchedule workSchedule)
	{
		
		ArrayList<UserAccount> users=load();
		for (UserAccount user: users)
		{
			if (user.getUser().getCode().equals(code))
			{
					user.getUser().setWorkSchedule(workSchedule);
					break;
			}
			
		}
		save(users);
		
	}
	
	public UserAccount searchByCode(String code)
	{
		ArrayList<UserAccount> users=getUsersByRole("DOCTOR");
		for (UserAccount user: users)
			if (user.getUser().getCode().equals(code))
				return user;
		return null;
	}
	
	
	
	
	}
	



