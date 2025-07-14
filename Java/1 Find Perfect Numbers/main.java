package main;

import java.util.Scanner;

public class main
{
	public static void main(String[] args)
	{
		int n,i;
		int[] B;
		B=new int[100];
		System.out.println("search for perfect numbers from 1 to:");
		Scanner cs = new Scanner(System.in);
		n=cs.nextInt();
		
		
		B=euresi(n);
		System.out.print("Perfect numbers starting from  1 to "+n+" are:\n");
		for(i=0;i<B.length;i++)
		{
			if(B[i]==0)
			{
				break;
			}
			System.out.print(B[i]+" ");
		}
	}
	
	
	// find perfect numbers 
	public static int[] euresi(int n)
	{
			int[] A;
			int i,j,q=0,d=0;
			A = new int[100];
			
			
			for(i=2;i<=n;i++)
			{
				for(j=1;j<i;j++)
				{
					if((i%j)==0)
					{
						d=d+j;
					}
					//if d > i number is not perfect
					if(d>i)
					{
						break;
					}
				}
				if(d==i)
				{
					A[q]=d;
					q++;
				}
				d=0;
			}					
			return A;
	}
		
}