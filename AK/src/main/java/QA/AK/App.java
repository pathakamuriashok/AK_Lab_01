package QA.AK;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
     // Get the current working directory using System.getProperty("user.dir")
        String projectDirectory = System.getProperty("user.dir");

        // Print the project directory
        System.out.println("The project directory is: " + projectDirectory);
    }
}
