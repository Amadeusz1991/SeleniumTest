package pl.testeroprogramowania;
import org.testng.annotations.*;

public class BaseTest {
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("I am before Suite");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("I am before class");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("I am after Suite");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("I am after class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("I am running before test");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("I am running before method");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("I am running after test");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("I am running after method");
    }
}
