#include <stdio.h>
#include <math.h>
float mySqrt( float a,int *i);
int checkFloat(float a);
int main() {
    float a,z,q;
    int *i,p;
    
    printf("Give the number you want find square root: \n");
    scanf("%f",&a);
    if(checkFloat(a))  
    {    
         i=&p;
         q=a;
         z=sqrt(a);
         a= mySqrt(a,i);  
         
         /*results*/
         printf("\nsquare root found on %d repetitions\n",p);
         printf("\nsquare root babylonian method: %8.8f\n",a);
         printf("\nsquare root of %f by sqrt is: %8.8f\n",q,z);
         printf("\ndifference of babylonian with sqrt : %8.8f\n",fabs(z-a));
         scanf("%f",&a);
    }
    else
    printf("\nNumber must be > 0\n");
    scanf("%f",&a);
}

float mySqrt( float a,int *i)
{
    float x1,x2;
    *i=1;              /*Babylonian method*/
    x1=1.0;
    x2=(1.0/2.0)*(x1+ (a/x1));
    while(fabs((x2-x1)) >= 0.00001)
    {
        x1=x2;
        x2=(1.0/2.0)*(x1+ (a/x1));
        *i=*i+1;
    }
    return x2;
}


int checkFloat(float a)
{
    if(a<=0)
    return 0;
    if(a>0)
    return 1;
}    
