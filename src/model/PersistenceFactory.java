package model;

public class PersistenceFactory {
	
	public Persistence getPersistence(String persistenceType)
	{
		if (persistenceType==null)
		{
			return null;
		}
		
		else if (persistenceType.equalsIgnoreCase("CONT UTILIZATOR"))
		{
			return new UserAccountPersistence("conturi.ser");
		}
		else if (persistenceType.equalsIgnoreCase("ANIMAL"))
		{
			return new AnimalPersistence("animale.ser");
		}
		else if (persistenceType.equalsIgnoreCase("PROGRAMARE"))
		{
			return new AppointmentPersistence("programari.ser");
		}
		return null;
	}

}
