## Steps required to run the application:

1. Download the latest version of PostgreSQL and install it
2. Define the following System Environment Variables:
    * POSTGRESQL_HOST - The name of the host on which PostgreSQL is installed
    * POSTGRESQL_PORT - The port of the host on which PostgreSQL is running
    * POSTGRESQL_TASKIFY_DB_NAME - The name of the PostgreSQL database to which the connection needs to be made
    * POSTGRESQL_USERNAME - The name of the user who can access the PostgreSQL database
    * POSTGRESQL_PASSWORD - The password of the user who can access the PostgreSQL database
3. Make sure that you are creating the database pointed by the POSTGRESQL_TASKIFY_DB_NAME environment variable
4. To ensure that Lombok generates the required code correctly, follow the below mentioned steps:
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
5. Generate the public/private key-pair that will be used to validate/sign the JSON Web Token (JWT) by running the following piece of Java code in any online compiler:
```
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class RSAKeyGenerator {
    public static void main(String[] args) throws Exception {
        // Generate RSA Key Pair
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Use 2048 or 4096 for security
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        // Extract Private and Public Keys
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();

        // Encode in Base64
        String privateKeyBase64 = Base64.getEncoder().encodeToString(privateKey.getEncoded());
        String publicKeyBase64 = Base64.getEncoder().encodeToString(publicKey.getEncoded());

        // Print keys
        System.out.println("Private Key:\n" + privateKeyBase64);
        System.out.println("\nPublic Key:\n" + publicKeyBase64);
    }
}
```
6. Define the following System Environment Variables to ensure that JWT-based authentication works successfully in the application:
    * TASKIFY_JWT_SIGNATURE_PRIVATE_KEY - The private key generated in step 5 above that will be used to sign the JWT
    * TASKIFY_JWT_SIGNATURE_PUBLIC_KEY - The public key generated in step 5 above that will be used to validate the JWT
    * TASKIFY_JWT_EXPIRATION_TIME_MILLISECONDS - After what amount of time beginning from the time of JWT generation do we want the JWT to expire (in milliseconds)