## Steps required to run the application:

1. Download the latest version of PostgreSQL and install it
2. Define the following System Environment Variables:
    * POSTGRESQL_HOST - The name of the host on which PostgreSQL is installed
    * POSTGRESQL_PORT - The port of the host on which PostgreSQL is running
    * POSTGRESQL_TASKIFY_DB_NAME - The name of the PostgreSQL database to which the connection needs to be made
    * POSTGRESQL_USERNAME - The name of the user who can access the PostgreSQL database
    * POSTGRESQL_PASSWORD - The password of the user who can access the PostgreSQL database
4. Make sure that you are creating the database pointed by the POSTGRESQL_TASKIFY_DB_NAME environment variable
5. To ensure that Lombok generates the required code correctly, follow the below mentioned steps:
    * Navigate to the taskify project and expand the Maven Dependencies folder
    * Search for lombok-x.xx.xx.jar
    * Right click on the JAR file and select the Copy Qualified Name option
    * Quit Spring Tool Suite
    * Open an administrative command prompt and run the following command - java -jar <path-to-lombok-x.xx.xx.jar>
    * In the UI that options, select the Specify Location option, and browse to the location of the Spring Tool Suite executable file
    * Select the Install/Update option
    * Once the installation is successful, select the Quit Installer option
    * Start Spring Tool Suite
    * Right click on the project and select the Properties option
    * Expand the Java Compiler option and select the Annotation Processing option
    * Make sure that the Enable project specific settings, Enable annotation processing, and Enable processing in editor are all checked
    * Apply the changes which should trigger a recompile of the project
    * Once the project is recompiled, Lombok should start generating the required code correctly