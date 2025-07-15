The purpose of this exercise is to help you become familiar with the basic control structures in Java, as well as with reading arguments from the command line.

A
In this particular exercise, you must read 2 numbers as arguments from the command line, which must be greater than or equal to zero.
Next, you must create a method that finds the greatest common divisor (GCD) of these two numbers.

B
Then, after reading 2 more numbers from the command line,
you must implement a method that finds the greatest common divisor using Euclid's algorithm. This algorithm must be implemented recursively and is defined as follows:
gcd(a, b) := a if a = b
gcd(a, b) := gcd(a - b, b) if a > b
gcd(a, b) := gcd(a, b - a) if b > a