From theory, we know that Newton's method can fail. For example, it is possible that the sequence xn→∞ 
for some initial value x0x_0x0, or that f′(xk)=0 at some step k.
Another way for the method to fail is as follows: Suppose for some initial guess x0x_0x0, it happens that x1≠x0 but x2=x0. It is easy to see that in this case, the Newton iteration will cycle as:
x0,x1,x0,x1,…
Check if such behavior occurs for the function:
f(x):=x−2tanh⁡(x)=0
Try to find an initial value x0x_0x0 that leads to this oscillating behavior. Compute its value accurately to 6 decimal digits.
Find an interval that contains such an 
𝑥0 , and use bisection method or a root-finding function like ZEROIN to locate it.
Then, rerun your Newton’s method program using this specific 
𝑥0 to observe the behavior when trying to find a root of 𝑓(𝑥)