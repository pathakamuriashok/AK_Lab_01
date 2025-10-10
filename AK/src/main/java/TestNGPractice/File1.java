package TestNGPractice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class File1 
{
	@BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("BeforeSuite: Setting up the test suite environment.");
    }

    // Runs before any test method belonging to the classes inside the <test> tag in testng.xml
    @BeforeTest
    public void beforeTestMethod() {
        System.out.println("BeforeTest: Initializing test-specific resources.");
    }

    // Runs once before the first test method in the current class
    @BeforeClass
    public void beforeClassMethod() {
        System.out.println("BeforeClass: Setting up resources for the class.");
    }

    // Runs before each @Test method
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: Preparing for a test method execution.");
    }

    // A test method
    @Test
    public void testMethod1() {
        System.out.println("Test: Executing testMethod1.");
        // Add actual test logic and assertions here
    }

    // Another test method
    @Test
    public void testMethod2() {
        System.out.println("Test: Executing testMethod2.");
        // Add actual test logic and assertions here
    }

    // Runs after each @Test method
    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: Cleaning up after a test method execution.");
    }

    // Runs once after all the test methods in the current class have run
    @AfterClass
    public void afterClassMethod() {
        System.out.println("AfterClass: Tearing down resources for the class.");
    }

    // Runs after all the test methods belonging to the classes inside the <test> tag have run
    @AfterTest
    public void afterTestMethod() {
        System.out.println("AfterTest: Cleaning up test-specific resources.");
    }

    // Runs once after all tests in the suite
    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("AfterSuite: Tearing down the test suite environment.");
    }
}
