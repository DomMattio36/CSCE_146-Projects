//written by Dominic Mattio :) 
import java.io.*;
import java.util.Scanner;
public class GameCollectionFE 
{

	
	public static void main(String[] args) 
{
		Scanner scan = new Scanner(System.in);
boolean quit = false;
String filename;
GenLL<GameCollection> gLL= new GenLL<GameCollection>(); //full list of games and consoles
GenLL<GameCollection> results= new GenLL<GameCollection>(); //list of games and consoles that will actually be printed

while(quit == false) //checks if the user has selected quit
{
	System.out.println("Enter 1 to load the video game database\r\n"
			+ "\r\n"
			+ "Enter 2 to search the database\r\n"
			+ "\r\n"
			+ "Enter 3 to print current results to the console\r\n"
			+ "\r\n"
			+ "Enter 4 to print current results to file\r\n"
			+ "\r\n"
			+ "Enter 0 to quit");	

	int choice = scan.nextInt(); //checks for user input
	scan.nextLine();
	if(choice == 1)
	{
	try 
	{
	System.out.println("Please enter the filename");
	filename = scan.nextLine();
	Scanner filescan = new Scanner(new File(filename));
	gLL = new GenLL<GameCollection>();
	while(filescan.hasNextLine()) 
		{
		String line = filescan.nextLine();
		String gameName = line.substring(0,line.indexOf("\t"));
		String consoleName = line.substring(line.indexOf("\t"));
		
		GameCollection a = new GameCollection(gameName,consoleName);
		gLL.add(a);
		
		
		
		}
	System.out.println("File loaded");
	filescan.close();
	}
	catch(FileNotFoundException e) //checks for file error, repeated multiple times
		{
		System.out.println("File not found");
		}
	}
	
	
	else if(choice == 2) 
	{		
		results= new GenLL<GameCollection>();
		System.out.println("Enter the game name or press * for all");
		String answer = scan.nextLine();
		
		if(answer.equals("*")) 
		{
			gLL.reset();
			while(gLL.hasMore()) 
			{
				results.add(gLL.getCurrent());
				gLL.gotoNext();
			}
		}
		else 
		{
			gLL.reset();
			
			while(gLL.hasMore()) 
			{
				String nameCheck = gLL.getCurrent().getGame().toLowerCase(); //case insensitive
				if(nameCheck.contains(answer.toLowerCase())) 
				{
					results.add(gLL.getCurrent());
					gLL.gotoNext();
				}
				else 
				{
					gLL.gotoNext();
				}
			}	
		}
		
		System.out.println("Enter the console name or press * for all");
		String answertwo = scan.nextLine();

		if(answertwo.equals("*")) 
		{
			
			
			
				
		}
		else 
		{
			results.reset();
			
			while(results.hasMore()) 
			{
				String consoleCheck = results.getCurrent().getConsole().toLowerCase();
				if(consoleCheck.contains(answertwo.toLowerCase())) 
				{
					
					results.gotoNext();
				}
				else 
				{
					results.removeCurrent();
				}
			}	
		}
		results.print();	
	}
	else if(choice == 3) 
	{
		results.print();
	}
	else if(choice == 4) 
	{
		try
	    {
	        System.out.println("Enter new file name");
	        String outputFileName = scan.nextLine();
	        //checks if user wants to append or replace
	        System.out.println("Would you like to append? True or false?");
	        boolean append = scan.nextBoolean();
	        scan.nextLine();

	        PrintWriter output = new PrintWriter(
	                new FileOutputStream(outputFileName, append));

	        results.reset();

	        while(results.hasMore())
	        {
	            output.println(results.getCurrent());
	            results.gotoNext();
	        }

	        output.close();
	        System.out.println("Results written to file");
	    }
	    catch(FileNotFoundException e)
	    {
	        System.out.println("Could not write to file");
	    }
	}
	else if(choice == 0) 
	{
	 quit = true;
	}
	else
	{
		System.out.println("Not a valid input");
	}
	
}	

scan.close();
}
}
