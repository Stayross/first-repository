#include <stdio.h>
#include <math.h>
int main()
{
    int m,n,i,j,A[100000],g,s,e,p,x,b,k;
    double m_o,sum;
    char c[15];
    
    /*check if user gives number*/
    here: for(i=0;i<=15;i++)
    c[i]='0';
    g=0;
    printf("Give integer m\n");
    scanf("%s",&c);
    for(i=0;i<=15;i++)
    {   
        m=c[i]-48;
        g=g+1;
        if(m== -48)       
        goto edw;
        if(m <0 || m>9)
        {printf("Wrong data\n");
        goto here;}
    }
    edw: m=0;
    for(i=g-2;i>=0;i--)
    {    
    s=g-i-2;
    m=m+ ( (c[i]-48) * ( pow(10,s) ) ) ;
    }
    
    /*check if user gives number*/
    here2: for(i=0;i<=15;i++)
    c[i]='0';
    g=0;
    printf("Give integer n\n");
    scanf("%s",&c);
    for(i=0;i<=15;i++)
    {   
        n=c[i]-48;
        g=g+1;
        if(n== -48)
        goto edw2;
        if(n <0 || n>9)
        {printf("Wrong data\n");
        goto here2;}
    }
    edw2: n=0;
    for(i=g-2;i>=0;i--)
    {    
    s=g-i-2;
    n=n+ ( (c[i]-48) * ( pow(10,s) ) ) ;
    }
    
    
    if(m>n)
    {e=m;
    m=n;        /*check of user gives opposite numbers*/
    n=e;}
    
    if(m%2 != 0)
    {printf("m odd (do not included in results)\n");
    m=m+1;}
    if(n%2 !=0)
    {printf("n odd (do not included in results)\n");
    n=n-1;}
    


    
    e=0;    
    p=0;                  /*calcutate first numbers until n+10*/
    for(i=1;i<n+10;i++)
    {
        for(j=1;j<i+1;j++)
        {        
             if(i%j == 0)
             {p=p+1;}
        }
        if(p==2)
        {     
              A[e]=i;
              e=e+1;
        }
        p=0;
    }

    
    
    
    sum=0.0;         /*calculate even number as add of firsts*/
    p=0;
    for(x=m;x<=n;x=x+2)
    {   
        if(x == 0)
        printf("0 can not written as sum of first numbers.   number of pairs: 0\n");
        else if(x == 2)
        printf("2 can not written as sum of first numbers.     number of pairs: 0\n");
        else
        {
             for(i=0;i<e;i++)
             {
                  for(j=i;j<e;j++)
                  {
                        if(A[i]+A[j] == x)
                        { p=p+1;
                          b=A[i];
                          k=A[j]; }
                  }
              }
              printf("\n%d = %d + %d         number of pairs: %d",x,b,k,p);
              sum=sum+p;
              p=0;
          }
    }
    m_o = 0.0;                  
    m_o =  sum/(((n-m)/2)+1);                                                      
    printf("\n\nThe average number of prime pairs that equal an even \ninteger between %d and %d is %lf\n",m,n,m_o);

}
