package model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class Persistence<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String fileName;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public void serialize(ArrayList<T> objects)
	{
		try {
			FileOutputStream fileOut=new FileOutputStream(fileName);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(objects);
			out.close();
			fileOut.close();
			System.out.println("Serialized successfully");
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public  ArrayList<T> deserialize()
	{
		ArrayList<T> objects=new ArrayList<T>();
		try
		{
			FileInputStream fileIn=new FileInputStream(fileName);
			ObjectInputStream in=new ObjectInputStream(fileIn);
			objects= (ArrayList<T>) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Deserialized successfully");
			
		}catch(IOException e)
		{
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		return objects;
	}
	
	
	

	
	

}
