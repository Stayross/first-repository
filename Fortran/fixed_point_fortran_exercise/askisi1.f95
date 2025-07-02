      program ask1
      
      integer nmax,i,e
      double precision tol,x0,x1

      write(*,*)'give x0'
      read(*,*)x0
      write(*,*)'give tol'
      read(*,*)tol
      write(*,*)'give nmax'
      read(*,*)nmax
      
      x0=log10(x0)
      e=1
      x1=ffun(x0)
      i=1
   10 if(i .le. nmax) then
      write(*,*) 'n =', i, '   y(', i, ') =', x0, '   f(y) =', ffun(x0), '   |y(', i, ') - y(', i-1, ')| =', abs(x1 - x0)
      if( abs(x1-x0) .le. tol) then
      write(*,*)'Stable point is: ',x1
      i=nmax
      else
      e=e+1
      endif
      i=i+1
      x0=x1
      x1=ffun(x0)
      goto 10
      end if
      if( e .ge. nmax) then
      write(*,*)'Convergence was not achieved within ',nmax,' iterations.'
      endif
      stop
      end
      
      
      
      
      function ffun(x0)
      double precision x0
      ffun=2*tanh(x0)
      return
      end
      
