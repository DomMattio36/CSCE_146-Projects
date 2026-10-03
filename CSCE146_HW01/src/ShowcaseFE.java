
	import java.util.Scanner;

public class ShowcaseFE {
	
	public static final String FILE_NAME = ("./prizeList.txt");
	
	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		
		
		System.out.println("Hello, and welcome to the Showcase Showdown");
	
	boolean quit = false;	
	while(quit == false) { 	
		Showcase[] cases = new Showcase[5];
		
		String [] b = Showcase.readfile(FILE_NAME);
		
		
			
			
			
			
			
			int good = 0;
			while (good<cases.length) 
			{
				
				String check = b[(int)(Math.random()*b.length)];
				
				if(check.matches("[^\\t]+\\t\\d+")) 
				{
					cases[good]= new Showcase(check);
					good++;
					
				}
			}
		
		System.out.println("Here are your prizes");
		
		for (Showcase s : cases) 
		{
			System.out.println(s.getName());
		}
		
		
		System.out.println("You must guess the total cost of the prizes without going over and within $1,300 of its actual price");
			
		System.out.println("Enter your guess");

		int numguess = scan.nextInt();
		int tot = 0;
		
		for (Showcase s : cases) 
		{
			tot += s.getPrice();
			
		}
		
		System.out.println("The actual cost is " + tot);
		
		if(numguess == (int)tot) 
		{
			System.out.println("Correct! You win!");
			
		}
		else if ((numguess) <= (int)tot && ((int)tot - 1300) <= numguess ) 
		{
			System.out.println("You win!");
		}
		else if(numguess > (int)tot) 
		{
			System.out.println("Too high!");
		}
		else
			System.out.println("Too low!");
		
		System.out.println("Would you like to continue? Press q if you want to quit. Type any other character to continue.");
		
		String q = scan.next();
		
		if (q.equals("q"))
			quit = true;
			
		
		}	
	}

}
