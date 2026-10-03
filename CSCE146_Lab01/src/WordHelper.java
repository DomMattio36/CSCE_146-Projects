//Made by Dominic Mattio :)

public class WordHelper {

	//checks if a letter is a vowel
		public static boolean isVowel(String a) 
		{
			if (a.toLowerCase().equals("a") || a.toLowerCase().equals("e") || a.toLowerCase().equals("i") || a.toLowerCase().equals("o") || a.toLowerCase().equals("u"))
			{
				return true;
			}
			else
				return false;
		}
	
		
		
	//counts how many vowels there are in a word
		public static int vowCount(String b) 
		{
			int count=0;
			for (int i=0;i<b.length();i++) 
			{
				if ( isVowel(b.substring(i,i+1)) == true ) 
				{
					count++;
				}
			}
			return count;
		}
//counts how many consonants there are in a word using the vowel checker	
		public static int conCount(String c) 
		{
			int count=0;
			for (int i=0;i<c.length();i++) 
			{
				if ( isVowel(c.substring(i,i+1)) == false ) 
				{
					count++;
				}
			}
			return count;
		}
		
	//sorts an array from word with least vowels to word with most vowels
	public static String[] sortByVowels(String[] arr)
		{
			String[] ans = new String[arr.length];
			
				for(int g=0; g<arr.length; g++) 
					{
					ans[g] = arr[g];
					}
			
			for(int p=0; p<ans.length-1;p++) {	
			
				for (int i=0; i<ans.length-1;i++) 
			
				{
					if( vowCount(ans[i]) > vowCount(ans[i+1]) ) 
					{
					String current = ans[i];
					String next = ans[i+1];
					
					ans[i] = next;
					ans [i+1] = current;
					}
			
				}
			}
			
			return ans;	
		}
	
// same as the last sorter but for consonants instead of vowels
		public static String[] sortByConsonants(String[] arr) 
		{
			String[] ans = new String[arr.length];

			for(int g=0; g<arr.length; g++) 
			{
			ans[g] = arr[g];
			}
	
	for(int p=0; p<ans.length-1;p++) {	
	
		for (int i=0; i<ans.length-1;i++) 
	
		{
			if( conCount(ans[i]) > conCount(ans[i+1]) ) 
			{
			String current = ans[i];
			String next = ans[i+1];
			
			ans[i] = next;
			ans [i+1] = current;
			}
	
		}
	}
	
	return ans;
		}


	//sorts array by length of word. This one should be way easier.
	
	public static String[] sortByLength(String[] arr) 
	{
		String[] ans = new String[arr.length];
			for(int i =0; i<arr.length; i++) 
			{
				ans[i] = arr[i];
			}
		
		for(int p=0;p<ans.length-1;p++) 
		{
			for (int i=0;i<ans.length-1;i++) 
			{
				if( ans[i].length() > ans[i+1].length() ) 
				{
					String current = ans[i];
					String next = ans[i+1];
					
					ans[i] = next;
					ans[i+1] = current;
				}
			}
		}
		
		
		
		return ans;
	}
		
		
		
		
}
		

