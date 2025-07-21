Consider the following algorithm that generates a sequence of numbers:
We start with a natural number n. If n is even, we divide it by 2. 
If n is odd, we multiply it by 3 and add 1. 
We repeat the process with the new value of n and terminate when n=1.
For example, the following sequence is generated when starting with 
n=22: 22, 11, 34, 17, 52, 26, 13, 40, 20, 10, 5, 16, 8, 4, 2, 1
It has been conjectured (though not yet proven) that this algorithm will always terminate at n=1
for every natural number n. This conjecture has been verified for all natural numbers up to at least 1,000,000.
For a given input n, the cycle length of n is defined as the number of terms generated from n 
up to and including the terminating 1. 
In the example above, the cycle length of 22 is 16. 
We denote the cycle length of n as C(n), so C(22)=16.

Program Requirements:
The program should take two integers 
m and k as input from the user and compute:

1. The maximum cycle length for all numbers between m and k (inclusive).
2. The average cycle length for the same range.
3. The number that achieves the maximum cycle length.

If there are multiple numbers in the range [m,k] that achieve the same maximum cycle length C(n), 
the program should output any one of them (it does not matter which one). 
