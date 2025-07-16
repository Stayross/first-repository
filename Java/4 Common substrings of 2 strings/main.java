
import java.io.*;

public class askisi4 
{
	
	public static void main(String[] args)
	{
		boolean logical;
		String A = null;
		String B = null;
		
		// Check if the phrases are anagrams
		logical = askisi4.anagramatismos(args[0], args[1]);
		
		if(logical == true)
		{
			System.out.println("The phrase: " + args[0] + " is an anagram of the phrase: " + args[1]);
		}
		else
		{
			System.out.println("The phrase: " + args[0] + " is NOT an anagram of the phrase: " + args[1]);
		}
		
		// Part B
		System.out.println("Enter two strings:");

		BufferedReader temp;
		InputStreamReader temp2;
		temp2 = new InputStreamReader(System.in);
		temp = new BufferedReader(temp2);

		try {
			A = temp.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			B = temp.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		A = A.toLowerCase();
		B = B.toLowerCase();
		String[] D;
		D = new String[arithmei(A.length())];
		D = vresuposunola(A).clone();

		elegxosisotitas(D, B);
	}
	
	// Checks if the phrase represented by string A 
	// is an anagram of the phrase represented by string B
	static boolean anagramatismos(String A, String B)
	{
		boolean logical = true;
		
		A = A.replace(" ", "");
		A = A.toLowerCase();
		char[] pinakas = A.toCharArray();
	    java.util.Arrays.sort(pinakas);
	    String taksinomimenos = new String(pinakas);
	    
	    B = B.replace(" ", "");
		B = B.toLowerCase();
		char[] pinakas2 = B.toCharArray();
	    java.util.Arrays.sort(pinakas2);
	    String taksinomimenos2 = new String(pinakas2);
		
	    logical = taksinomimenos.equals(taksinomimenos2);
		
		return logical;
	}
	
	// Returns the sum 1 + 2 + 3 + ... + a
	public static int arithmei(int a)
	{
		int i, sum = 0;
		for(i = 1; i < a; i++)
		{
			sum = sum + i;
		}
		return sum;
	}
	
	// Finds all substrings (length > 2) of string l
	// Returns them stored in a string array
	public static String[] vresuposunola(String l)
	{
		int i, j, z = 0;
		String[] A;
		A = new String[arithmei(l.length())];
		for(i = 0; i <= l.length() - 2; i++)
		{
			for(j = i + 2; j <= l.length(); j++)
			{
				A[z] = l.substring(i, j);
				z++;
			}
		}
		
		return A;
	}
	
    // Checks if string k is contained in the string array l
	public static void elegxosisotitas(String[] l, String k)
	{
		int i;
		for(i = 0; i < l.length; i++)
		{
			if(l[i] != null)
			{
				if(k.contains(l[i]))
				{
					System.out.println(l[i]);
				}
			}     
		}
	}
}
