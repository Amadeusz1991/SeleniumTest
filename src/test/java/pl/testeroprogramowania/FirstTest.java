package pl.testeroprogramowania;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.Connection;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FirstTest extends BaseTest {

    WebDriver driver;

    @Test @Ignore
    public void firstTest () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementExist(By.cssSelector("p"));

        String paraTest = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraTest,"Dopiero się pojawiłem!");
        driver.quit();
    }
    @Test
    public void secondTest () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");
        driver.findElement(By.id("clickOnMe")).click();
        waitForElementExist(By.cssSelector("p"));

        String paraTest = driver.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(paraTest,"Dopiero się pojawiłem!");
        driver.quit();
    }

    public void waitForElementExist (By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver);
        wait.ignoring(NoSuchElementException.class);
        wait.withTimeout(Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofSeconds(1));

        // własny warunek, który sprawdza co sekundę w przedziale czasowym 10s czy warunek jest spełniony czy nie.
        wait.until((driver) -> {

                List<WebElement> elements = driver.findElements(locator);
                if (elements.size() > 0) {
                    System.out.println("Element jest na stronie");
                    return true;
                } else {
                    System.out.println("Nie ma na stronie");
                    return false;
                }

            });
      }
    }

