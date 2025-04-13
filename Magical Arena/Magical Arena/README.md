# Magical Arena

## Prerequisites
- Java 22 or later versions
- Maven 3.0 or later versions

## Installing

1. Unzip the project into a local directory.
2. Navigate to the project's root directory using the command line/terminal.
3. Run the following Maven command to ensure all dependencies are up-to-date and tests pass:
    ```bash
    mvn clean install
    ```
   After successful execution of the above command (which might take some time depending on your system speed and internet connection), you should see a `BUILD SUCCESS` message in your command line.

## Playing the Game

To run the application:

1. Navigate to the project's root directory using the command line/terminal.
2. Run the command:
    ```bash
    mvn exec:java
    ```
3. You will then be prompted to enter the details for Player 1 and Player 2. All values must be positive integers.

## Running the Tests

To run the tests separately, execute the following command:
```bash
mvn test
