package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AnimalStatistics {
	private ArrayList<Animal> animals = new ArrayList<Animal>();
	
	 public void AddAnimal(Animal animal)
     {
         animals.add(animal);
     }

	public ArrayList<Animal> getAnimals() {
		return animals;
	}

	public void setAnimals(ArrayList<Animal> animals) {
		this.animals = animals;
	}
	public HashMap<String,Integer> getStatistics(String criterion)
	{
		HashMap<String, Integer> stats=new HashMap<String, Integer>();
		for (Animal a:animals)
		{
			String value = a.getCriterion(criterion);
			boolean exists = false;
	        Iterator<Map.Entry<String,Integer> > iterator = stats.entrySet().iterator(); 
	        while (iterator.hasNext()) { 
	            Map.Entry<String,Integer> entry = iterator.next(); 
	  
	            if (a.getCriterion(criterion).equals(entry.getKey())) { 
	            	exists=true;
	            	break;
	            }
	                               
	        } 
	        if (exists==true)
	        	stats.computeIfPresent(value,  (k, v) -> v + 1);
	        else
	        	stats.put(value,1);
		}
		return stats;
	}

}
