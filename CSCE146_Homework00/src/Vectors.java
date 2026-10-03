// written by Dominic Mattio :)



import java.util.Scanner;

//declare class
public class Vectors {
	
	
	
	
	
	
	//add vectors
	public static Double[] add(Double[] a, Double[] b) 
	{
		Double[] ret = new Double[a.length];
		
		for(int i = 0; i<ret.length; i++) 
		{
			ret[i]= a[i] + b[i];
		}
		return ret;
	}
	
	//subtract vectors
	public static Double[] sub(Double[] a, Double[] b) 
	{
		Double[] ret = new Double[a.length];
		
		for(int i = 0; i<ret.length; i++) 
		{
			ret[i]= a[i] - b[i];
		}
		return ret;
	}
	//find magnitude
	public static Double findMag(Double[] v) 
	{
		Double tot = 0.0;
		
		for(int i=0;i<v.length;i++) 
		{
			tot += (v[i])*(v[i]);
		}
		Double fin = Math.sqrt(tot);
		return fin;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		
		//keep runnning code until quit is selected
while (true)
{
	System.out.println("Welcome to the Vector Operation Program!");
	System.out.println("Enter 1. To add 2 Vectors");
	System.out.println("Enter 2. To subtract 2 Vectors");
	System.out.println("Enter 3. To find the magnitude of a Vector");
	System.out.println("Enter 9. To Quit");
	int in = scan.nextInt();
		
	if (in==1) 
		{
			System.out.println("Enter the size of the vectors");
			
			int size = scan.nextInt();
				
			while (size<1) 
				{
					System.out.println("Size must be at least 1");
					size = scan.nextInt();
				}
			
				
			Double[] firstAdd= new Double[size];
			Double[] secondAdd= new Double[size];

			System.out.println("Enter the values of Vector 1");
			
			for(int i=0;i<firstAdd.length;i++) 
				{
					firstAdd[i]=scan.nextDouble();
				}
			
			System.out.println("Enter the values of Vector 2");
			
			for(int i=0;i<secondAdd.length;i++) 
				{
					secondAdd[i]=scan.nextDouble();
				}
			
			Double[] ans = Vectors.add(firstAdd, secondAdd);
			System.out.println("Result:");
						
			for(int i =0;i<ans.length;i++) 
				{
					System.out.println(ans[i]);
				}
				
				
		}
			
		else if(in==2) 
		{
			System.out.println("Enter the size of the vectors");
			
			int size = scan.nextInt();
			
			while (size<1) 
			{
				System.out.println("Size must be at least 1");
				size = scan.nextInt();
			}
			
			Double[] firstSub = new Double[size];
			Double[] secondSub = new Double[size];

			System.out.println("Enter the values of Vector 1");
			
			for(int i=0;i<firstSub.length;i++) 
				{
				firstSub[i]=scan.nextDouble();
				}
	
			System.out.println("Enter the values of Vector 2");
	
			for(int i=0;i<secondSub.length;i++) 
			{
				secondSub[i]=scan.nextDouble();
			}
			
			Double[] ans = Vectors.sub(firstSub, secondSub);
			System.out.println("Result:");
			
			for(int i =0;i<ans.length;i++) 
			{
				System.out.println(ans[i]);
			}
		
		}
		
		else if(in==3) 
		{
			System.out.println("Enter the size of the vector");
			int size = scan.nextInt();
			
			while (size<1) 
				{
					System.out.println("Size must be at least 1");
					size = scan.nextInt();
				}
			
			Double[] check = new Double[size];
			
			System.out.println("Enter the values of the vector");
			
			for(int i=0;i<check.length;i++) 
				{
				check[i]=scan.nextDouble();
				}
			
			System.out.println("The magnitude is " + Vectors.findMag(check));
		}
		else if(in==9) 
		{
			System.out.println("Thank you for using my program");
			break;
		}
		else
			System.out.println("Please enter a valid number");
		
}
	
	scan.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
