Steps required to run the application:
1) Download the latest version of PostgreSQL and install it
2) Define the following System Environment Variables:
a) POSTGRESQL_HOST - The name of the host on which PostgreSQL is installed
b) POSTGRESQL_PORT - The port of the host on which PostgreSQL is running
c) POSTGRESQL_TASKIFY_DB_NAME - The name of the PostgreSQL database to which the connection needs to be made
d) POSTGRESQL_USERNAME - The name of the user who can access the PostgreSQL database
e) POSTGRESQL_PASSWORD - The password of the user who can access the PostgreSQL database
3) Make sure that you are creating the database pointed by the POSTGRESQL_TASKIFY_DB_NAME environment variable
4) To ensure that Lombok generates the required code correctly, follow the below mentioned steps:
a) Navigate to the taskify project and expand the Maven Dependencies folder
b) Search for lombok-x.xx.xx.jar
c) Right click on the JAR file and select the Copy Qualified Name option
d) Quit Spring Tool Suite
e) Open an administrative command prompt and run the following command - java -jar <path-to-lombok-x.xx.xx.jar>
f) In the UI that options, select the Specify Location option, and browse to the location of the Spring Tool Suite executable file
g) Select the Install/Update option
h) Once the installation is successful, select the Quit Installer option
i) Start Spring Tool Suite
j) Right click on the project and select the Properties option
k) Expand the Java Compiler option and select the Annotation Processing option
l) Make sure that the Enable project specific settings, Enable annotation processing, and Enable processing in editor are all checked
m) Apply the changes which should trigger a recompile of the project
n) Once the project is recompiled, Lombok should start generating the required code correctly
