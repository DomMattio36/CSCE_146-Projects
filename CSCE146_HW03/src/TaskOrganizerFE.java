//written by Dominic Mattio :)

import java.io.*;
import java.util.Scanner;
public class TaskOrganizerFE {

	public static void main(String[] args) 
	{
		
		Scanner scan = new Scanner(System.in);		
		GenLL<OrganizedTask> taskList = new GenLL<OrganizedTask>();
		boolean quit = false;
		
		while(quit == false) 
		{
			System.out.println("Welcome to the Task Organizer." + "\r\n" + "Enter 1. To Add a Task\r\n"
					+ "\r\n"
					+ "Enter 2. To Remove a Task\r\n"
					+ "\r\n"
					+ "Enter 3. To Print Tasks To Console\r\n"
					+ "\r\n"
					+ "Enter 4. To Read from a Task File\r\n"
					+ "\r\n"
					+ "Enter 5. To Write to a Task File\r\n"
					+ "\r\n"
					+ "Enter 6. To Quit\r\n");
			int input = scan.nextInt();
			scan.nextLine();
			switch(input) //I learned this outside of class
			{
			case 1: 
				System.out.println("Enter the name of the task");
				String a = scan.nextLine();
				System.out.println("Enter the priority of the task");
				int b = scan.nextInt();
				OrganizedTask newTask = new OrganizedTask(b,a);
				taskList.add(newTask);
				break;
			case 2:
				System.out.println("Enter the Name of the Task you want to remove");
				String remName = scan.nextLine();
				System.out.println("Enter the Priority of the Task you want to remove");
				int remPrio = scan.nextInt();
				OrganizedTask rem = new OrganizedTask(remPrio,remName);
				taskList.remove(rem);
				break;
			case 3:
				taskList.current = taskList.head;
				while(taskList.current != null) 
				{
					taskList.current.data.print();
					taskList.current = taskList.current.link;
				}
				break;
			case 4:
				try
				{
					System.out.println("Enter the name of the file");
					String filename = scan.nextLine();
					Scanner filescan = new Scanner(new File("./" + filename));
					
					while(filescan.hasNext()) 
					{
						String f = filescan.nextLine();
						taskList.add(OrganizedTask.read(f));
					}
					
				}
				catch(FileNotFoundException e) 
				{
					System.out.println("File not found");
				}
				break;
			case 5:
				try 
				{
					System.out.println("Enter the name of the file you want to write to");
					String writeFile = scan.nextLine();
					FileWriter writer = new FileWriter(writeFile);
					
					taskList.current = taskList.head;
					while(taskList.current != null) 
					{
						writer.write(taskList.current.data.getPriority() + "\t"
						        + taskList.current.data.getAction() + "\n");
						taskList.current = taskList.current.link;
					}
					
					
					writer.close();
				}
				catch(IOException e) 
				{
					System.out.println("File not found");
					
				}
				break;
			case 6:
				quit = true;
				break;
			}
			

		}
		
		
		
		
	}

}
