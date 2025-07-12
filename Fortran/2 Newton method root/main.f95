      program askisi1
      double precision x0,toll,x
      integer nmax,i,e
      
      write(*,*)'Give x0 , toll( toll>0 ) and nmax'
      read(*,*)x0,toll,nmax
      
      e=1
      i=1
   10 if(i .le. nmax) then
      x=x0-(ffun(x0)/dfun(x0))
      write(*,*)'n=',i,'   xn=',x0,'    f(xn)=',ffun(x0),'   |xn+1-xn|=',abs(x-x0)
      if( abs(x-x0) .le. toll) then
      write(*,*)'Root is: ',x
      i=nmax
      else
      e=e+1
      endif
      i=i+1
      x0=x
      goto 10
      endif
      if( e .ge. nmax) then
      write(*,*)'Do not achieved coverense at ',nmax,' repeats'
      endif
      stop
      end
      
      
      function ffun(x0)
      double precision x0
      ffun= x0-2*((exp(x0)-exp(-x0))/(exp(x0)+exp(-x0)))
      return
      end
      
      function dfun(x0)
      double precision x0
      dfun= 1-2*(2/(exp(x0)+exp(-x0)))**2
      return
      end