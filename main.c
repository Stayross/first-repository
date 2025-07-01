#include <stdio.h>
#include <math.h>
main()
{
    int m,n,q,p,i,j,e,A[100000],t,g,s;
    char c[15];
    
    /*ELEGXOS AN TO M EINAI ARITHMOS KAI OXI GRAMA I SYMBOLO*/
    here: for(i=0;i<=15;i++)
    c[i]='0';
    g=0;
    printf("dwse ton akeraio m\n");
    scanf("%s",&c);
    for(i=0;i<=15;i++)
    {   
        m=c[i]-48;
        g=g+1;
        if(m== -48)       
        goto edw;
        if(m <0 || m>9)
        goto here;
    }
    edw: m=0;
    for(i=g-2;i>=0;i--)
    {    
    s=g-i-2;
    m=m+ ( (c[i]-48) * ( pow(10,s) ) ) ;
    }
    
    /*ELEGXOS AN TO N EINAI ARITHMOS KAI OXI GRAMA I SYMBOLO*/
    here2: for(i=0;i<=15;i++)
    c[i]='0';
    g=0;
    printf("dwse ton akeraio n\n");
    scanf("%s",&c);
    for(i=0;i<=15;i++)
    {   
        n=c[i]-48;
        g=g+1;
        if(n== -48)
        goto edw2;
        if(n <0 || n>9)
        goto here2;
    }
    edw2: n=0;
    for(i=g-2;i>=0;i--)
    {    
    s=g-i-2;
    n=n+ ( (c[i]-48) * ( pow(10,s) ) ) ;
    }
   
    




    for(i=0;i<100000;i++)
    {    A[i]=0;    }

    if(n>m)
    {
        q=m;
        m=n;
        n=q;
    }
    p=0;
    e=0;
    for(i=n+1;i<m;i++)
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
    printf("\nOi protoi arithmoi metaksu tou %d me ton %d einai:\n",n,m);
    for(i=0;i<e;i++)
    {
        printf("%d ",A[i]);
    }
    printf("\nO arithmos twn prwtwn arithmwn einai %d\n",e);               
}
