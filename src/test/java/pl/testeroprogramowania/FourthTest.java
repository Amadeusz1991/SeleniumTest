package pl.testeroprogramowania;

import org.testng.annotations.Test;

public class FourthTest {

    @Test(dependsOnMethods = {"thirdTest"})
    public void firstTest() {

        System.out.println("I am first test");
    }
    @Test (dependsOnMethods = {"firstTest"})
    public void secondTest() {
        System.out.println("I am second test");

    }
    @Test
    public void thirdTest() {
        System.out.println("I am third test");

    }
}
