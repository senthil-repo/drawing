DISCLAIMER:
 Please install Java, Maven & other basic softwares that are needed to run any java based applications, in your machine.

LANGUAGE USED - Java

Please follow the steps below once you extract/un-zip the code from Git Bundle

1) Build process:
  Go to the folder 'drawing' where you can see 'pom.xml'. Open a command prompt in that folder and run the following command.
  
  mvn clean install
 
 This should create a target folder where you can see the jar file in the name 'consoledrawing-1.0.jar'.
 
2)Run the application: 
  Go to the target folder, open a command prompt and run the following command:
  java -jar consoledrawing-1.0.jar
  
  This should start-up the program. And you can supply the input commands to create the canvas and to draw the functions.
  

General Comments:
1) Initially started with a design that has a command interface which will be implemented by all the command operations. Later this approach has been dropped, as this will give un-neccessary dependencies between operations, and data flow will be scattered.
2) Create 2 seperate interfaces. One for canvas creation and one for other drawing functions.

3) Used Junit (for unit testing) & apache commons library (for utility apis and classes) only.