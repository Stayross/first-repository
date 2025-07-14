package askisi2;

import java.util.Random;;


public class askisi2 
{
	
	public static void main(String[] args)
	{
		int[] A,B;
		int i;
		A= new int[10];
		B= new int[2];
		A = random(A);
		
		System.out.print("A= [ ");
		for(i=0;i<A.length;i++)
		{
			System.out.print(A[i]+" ");
		}
		System.out.print("]");
		
		B=minimun(A);
		System.out.print("\nNeighboor numbers with min dif are: "+B[0]+" "+B[1]);
	}
	
//Gives random values	
	public static int[] random(int A[])
	{
		int i;
		Random generator = new Random();
		for(i=0;i<10;i++)
		{
			A[i]=generator.nextInt(101)+1;
		}
		
		return A;
	}
	
//finds minimun diference	
	public static int[] minimun(int A[])
	{
		int[] B;
		int i,minimun;
		minimun=101;
		B= new int[2];
		
		for(i=0;i<9;i++)
		{
			if(Math.abs(A[i+1]-A[i]) < minimun)
			{
				minimun= Math.abs(A[i+1]-A[i]);
				B[0]=A[i];
				B[1]=A[i+1];
			}
		}
		
		return B;
	}
	
}

