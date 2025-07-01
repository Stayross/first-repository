#include <stdio.h>
main()
{
	int i,m,k,x,j,A[1000],l,q,s;
	double m_o,sum;

	printf("give m\n");
	scanf("%d",&m);
	printf("give k\n");
	scanf("%d",&k);

	s=k+1;
	for(i=0;i<1000;i++)
	A[i]=0;
	for(i=m;i<s;i++)
	{
		j=1;
		x=i;
		while(x!=1)
		{
			if(x%2 == 0)
			{
				x=x/2;
			}
			else
			{
				x=x*3+1;
			}
			j=j+1;
		}
		A[i-m]=j;
	}
	sum=0;
	l=A[0];
	q=1;
	for(i=1;i<k-m+1;i++)
	{
		if(A[i] >= l)
		{	
			l=A[i];
			q=i+m;
		}
		sum = A[i-1] + sum;
	}
	sum = sum + A[k-m];
	m_o=sum/(k-m+1);
	printf("\nResults:\n");
	printf("Max cycle length: M(%d)=%d\n",q,l);
	printf("average cycle length: %lf",m_o);

}
