package model;

import java.util.ArrayList;

public class AnimalStatisticsBuilder {
	
	public AnimalStatistics createAnimalStatistics(ArrayList<Animal> animals)
	{
		AnimalStatistics animalStatistics=new AnimalStatistics();
		for (Animal a: animals)
			animalStatistics.AddAnimal(a);
		
		
		return animalStatistics;
		
	}

}
