/*written by Dominic Mattio :)*/
import java.io.*;
import java.util.Scanner;


public class Showcase {

	
	private String name;
	private int price;
	
	
	public Showcase(String a) 
	{
		
			this.name = a.substring(0, a.indexOf("\t"));
			this.price = Integer.parseInt(a.substring(a.indexOf("\t")+1));
		
	}
	
	/*I just clicked the getters and setters button on eclipse*/
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
			
		this.name = name;
	}
	
	public int getPrice() {
		
		
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
/*Readfile method that takes each line and puts it into an array of Strings*/	
	public static String[] readfile(String a) 
	{
		
		try
			{
			/*we went over how to make a filescan during lecture*/
				Scanner filescan = new Scanner(new File(a));
				Scanner filescantwo = new Scanner(new File(a));
				
				/*checks how many lines the file is so that I know how large to make the array*/
				int lines = 0;
				while (filescan.hasNextLine()) 
				
				{
					filescan.nextLine();
					lines++;
				}
				
				String[] fin = new String[lines];
				
				
				for(int i=0;i<fin.length; i++) 
				{
					
					fin[i] = filescantwo.nextLine();
				}
				
				
				
				filescan.close();
				filescantwo.close();
				return fin;
			}
		/*in case the code can't find the file, makes sure it doesn't crash*/
		catch (FileNotFoundException e)
			{
				System.out.println("Prize file not found");
				return new String[0];
			}
		
		
	}
	
	
	
}
