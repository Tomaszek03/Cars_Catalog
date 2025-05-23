# Cars Catalog (Back-end)

## Backend for a car shop web application (catalog of available cars)

### Used technologies:
* Java 17
* Maven
* Spring Boot

### How to start?

**Prerequisites:**
* Java JDK 17 (or newer) installed
* Maven (optional - project uses Maven Wrapper)

<br>

**Step 1.** Build project
* On Windows: 
    ``` cmd
    mvnw.cmd clean install
    ```

* On Linux/macOS: 
    ``` bash
    chmod +x mvnw  # make wrapper executable if needed
    ./mvnw clean install
    ```

<br>

**Step 2.** Run the application

After successful build, run the appropriate `JAR` file from `target` directory:
``` java
java -jar target/file-name.jar
```

<br>

Alternative for development (skip tests):
* On Windows: 
    ``` cmd
    mvnw.cmd spring-boot:run
    ```

* On Linux/macOS: 
    ``` bash
    ./mvnw spring-boot:run
    ```

<br>

**Additional commands:**
* Run tests only:
  * On Windows: 
    ``` cmd
    mvnw.cmd test
    ```

  * On Linux/macOS: 
    ``` bash
    ./mvnw test
    ```
* Skip tests during build:
  * On Windows: 
    ``` cmd
    mvnw.cmd clean install -DskipTests
    ```

  * On Linux/macOS: 
    ``` bash
    ./mvnw clean install -DskipTests
    ```
