	/* Written by Dominic Mattio :)*/
import java.io.*;
import java.util.Scanner;
/* imports  to make sure the code can scan text and files*/
public class FileIOSolutions {

	
	/* first method takes a file and converts all instances of is to was*/
	public static void pastTense(String fn, String oFn) 
	{
		try
		{
			Scanner filescan = new Scanner(new File(fn));
			PrintWriter output = new PrintWriter(new File(oFn));
			
			
			while(filescan.hasNext()) 
			{
				
				String a = filescan.next();
				if(a.toLowerCase().equals("is")) 
				{
					output.println("was");
					System.out.println("was");
				}
			
				else 
				{
					output.println(a);
					System.out.println(a);
				}
			}
			
			
		/*makes sure the scanners don't stay open forever*/
			filescan.close();
			output.close();
		}
		
		catch (FileNotFoundException e) 
		{
			System.out.println("No file found");
		}
	}
	/*Second method finds the total volume by parsing the text within a file into doubles and running them through a formula */
	public static double totalTubeVolume(String fn)
	{
		
		try 
		{
			Scanner filescan = new Scanner(new File(fn));
			
			double totVolume = 0;
			
			while (filescan.hasNextLine()) 
			{
				String a = filescan.nextLine();
			
	/*I had to look this part up. I didn't know .split beforehand so I had to learn how to use it during this lab*/
				String[] parts = a.split("\t");
				
				if (parts.length==3) 
				{
				try
					{
					double height = Double.parseDouble(parts[2]);
					double radius = Double.parseDouble(parts[1]);
				
				
					totVolume += ( radius * radius * height * Math.PI);
					}
				catch(NumberFormatException e) 
					{
					
					} 
				}	
			}
			filescan.close();
			return totVolume;
		}
		
		catch(FileNotFoundException e)
		{
			System.out.println("File not found");
			return 0.0;
		}
		
		
		
	}
	
	
}
