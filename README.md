# DevOps_J2EE
J2EE CRUD project for DevOps Platform


Instead of using a folder outside of your project, copy all necessary JARs into a lib/ folder inside of your project.

Now you can select all JARs in that folder, right click -> Build Path -> Add To Build Path.

Alternatively, you can define a "User Library" which contains all the JARs and add that single item to your project's build path.

Best solution  is to use Maven for this. Get the M2E Plugin for Eclipse and convert your project to a Maven project. Maven will manage all dependencies. 
                ** THIS PROJECT  IS  A MAVEN PROJECT **
