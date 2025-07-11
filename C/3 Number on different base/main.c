#include <stdio.h>
#include <ctype.h>
main()
{
    int a,b,i,q,x,A[100],p;
    
    b=2;
    while( (b<=10 && b > 0) && ( p=scanf("%d %d",&a,&b) == 2  ) )
    {
    q=0;
    x=a;
    while(x != 0 )
    {   
        A[q]=x%b;
        x=x/b;        
        q=q+1;
    }
    printf("%d in base %d is ",a,b);
    for(i=q-1;i>=0;i--)
    {
        printf("%d",A[i]);
    }
    printf("\n");
    }
}
        
        
    
