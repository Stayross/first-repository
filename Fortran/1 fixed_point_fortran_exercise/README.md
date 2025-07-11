Fortran program in double precision, which implements the iterative method
   y_{n+1} = φ(y_n)
for the approximation of a fixed point y* of the function φ.
As a termination criterion, use the following:
If |y_{n+1} - y_n| ≤ TOL for the first time, then consider y_{n+1} as a "fixed point."

For safety, execute at most NMAX iterations.
At each step n, your program should print the values of n, y_n, φ(y_n), and |y_{n+1} - y_n|.

In case your program executes the maximum number of iterations and the above convergence criterion is not satisfied,
then your program should print a message, e.g., "Convergence was not achieved within NMAX iterations."
