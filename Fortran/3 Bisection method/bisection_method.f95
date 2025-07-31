      program bisection_method
      implicit none
      integer :: i
      real :: n, m, a, b, c, e, l
      real :: f   ! Declare f as a real function
      external f  ! Optional, but recommended for clarity

      i = 1


  30  write(*,*) 'Enter a:'
      read(*,*) a
      write(*,*) 'Enter b:'
      read(*,*) b

      n = f(a)
      m = f(b)

      write(*,*) 'f(a) =', n
      write(*,*) 'f(b) =', m

      if (n * m .gt. 0.0) then
         write(*,*) 'Please enter valid values (f(a) * f(b) < 0)'
         goto 30
      end if

      e = 1.0e-9
      l = b - a

  10  if (l .le. e) then
         c = (a + b) / 2.0
         write(*,*) 'The root is: ', c
         write(*,*) 'Found in ', i, ' iterations'
         goto 20
      else
         c = (a + b) / 2.0
         m = f(c)
         if (m .eq. 0.0) then
            write(*,*) 'The root is exactly: ', c
            goto 20
         else
            if (f(a) * f(c) .gt. 0.0) then
               a = c
            else
               b = c
            end if
            l = l / 2.0
            i = i + 1
            goto 10
         end if
      end if

      write(*,*) 'No root found in ', i, ' iterations'
  20  stop
      end

      real function f(x)
      implicit none
      real :: x
      f = -x + 4.0 * x * (2.0 / (exp(x) + exp(-x)))**2 - 2.0 * ((exp(x) - exp(-x)) / (exp(x) + exp(-x)))
      return
      end
