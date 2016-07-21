# AnubisNetworks Exercise 1

* Requirements

  - Java 1.8

   
* Installation instructions

After uncompressing the file containing the development there are two approaches to launching the application:

1. Quick Launch

  - enter the folder generated from uncompressing the source package 
  - execute script exercise.sh
   
    > sh exercise.sh 


2. Detailed configuration

	The deployment package can be imported into Eclipse IDE by using Option File > Import > Existing Project into Workspace... 
	and selecting the main folder containing the application source code.
  
    
* Execution Instructions
    
  As requested the program reads its inputs from standard input. 
  Execution is supported by a set of project definition files (available in folder defs) defined to configure a set of different execution scenarios
  The quick launch script can be execute passing these files as redirected input
    > sh exercise.sh < defs/example.def
  
  
* References

  Implementation was done reusing library JGraphT (refer to http://jgrapht.org/) for graph processing support.
