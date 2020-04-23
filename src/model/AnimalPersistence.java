package model;

import java.util.ArrayList;

public class AnimalPersistence extends Persistence {
	
	public AnimalPersistence(String fileName)
	{
		this.setFileName(fileName);
	}
	
	public ArrayList<Animal> load()
	{
		ArrayList<Animal> animals = deserialize();
		return animals;
		
	}
	
	public void save(ArrayList<Animal> animals)
	{
	     serialize(animals);
	}

	public boolean add(Animal animal)
	{
		boolean added=false;
		ArrayList<Animal> animals=load();
		try {
			added=animals.add(animal);
			save(animals);
		}catch(Exception e)
		{
			System.out.println("Could not add animal");
		}
		
		return added;
	}
	public ArrayList<Animal> filter(String criterion, String info)
	{
		ArrayList<Animal> filtered = new ArrayList<Animal>();
		ArrayList<Animal> animals =load();
		for (Animal a: animals)
		{
			if (a.getCriterion(criterion).equals(info))
				filtered.add(a);
		}
		
		return filtered;
	}
	public ArrayList<Animal> filterByDoctorId(String criterion, String info,String id)
	{
		ArrayList<Animal> filtered = new ArrayList<Animal>();
		ArrayList<Animal> animals =load();
		for (Animal a: animals)
		{
			if (a.getCriterion(criterion).equals(info) && a.getDocCode().equals(id))
				filtered.add(a);
		}
		
		return filtered;
	}
	public ArrayList<Animal> getAllByDoctorId(String id)
	{
		ArrayList<Animal> filtered = new ArrayList<Animal>();
		ArrayList<Animal> animals =load();
		for (Animal a: animals)
		{
			if (a.getDocCode().equals(id))
				filtered.add(a);
		}
		
		return filtered;
	}

	
	
	public boolean delete(int index)
	{
		ArrayList<Animal> animals=load();
		boolean deleted=false;
		try {
			Animal a=null;
			a=animals.remove(index);
			if (a!=null)
				deleted=true;
			save(animals);
		} catch(Exception e)
		{
			System.out.println("Could not delete animal!");
		}
		
		return deleted;
		
	}
	public void deleteByDocCode(String docCode)
	{
		ArrayList<Animal> animals=load();
		ArrayList<Animal> newAnimals=new ArrayList<Animal>();
		for (Animal a:animals)
				if(!a.getDocCode().equals(docCode))
					newAnimals.add(a);
		save(newAnimals);
		
	}
	public boolean update(Animal a1,Animal a2)
	{
		boolean updated=false;
		int index=-1;
		ArrayList<Animal> animals=load();
		for (Animal a: animals)
			if (a.equals(a1)) {
				index=animals.indexOf(a);
				break;
			}
		if (index!=-1)
			try {
				animals.set(index, a2);
				save(animals);	
				updated=true;
			}catch (Exception e)
		{
				System.out.println("Could not update animal!");
				updated=false;
		}		
			
		return updated;
	}
	public Animal searchById(String id)
	{
		ArrayList<Animal> animals=load();
		for (Animal animal: animals)
			if (animal.getIdNo().equals(id))
				return animal;
		return null;
	}

}
