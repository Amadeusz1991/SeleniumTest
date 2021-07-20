import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

public class WaitTest {

    WebDriver driver;

    @Test
    public void waitTest () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        /* implicitlyWait jest o tyle lepsze od sleepa, ponieważ szuka elementu do 10s,
        ale jak tylko znajdzie to program idzie dalej, bez odczekiwania do końca 10s.
        Ważne jest to, że jest to używane dla całego kodu w tej klasie w każdym przypadku gdy czegoś szuka
         */
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/wait2.html");

        driver.findElement(By.id("clickOnMe")).click();
        // Sam Thread.sleep jest nie polecany ponieważ, to jest za hardkodowana wartość
        //Thread.sleep(5000);

        //WebDriverWait ignoruje wyjątki domyślnie bez definiowania tego
        /*WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("pa")));
        driver.findElement(By.cssSelector("p"));*/

        // FluentWait nie ignoruje domyslnie NotFoundExepction odnosnie elementów i trzeba do samemu definiować
        FluentWait<WebDriver> wait1 = new FluentWait<>(driver);
        wait1.ignoring(NoSuchElementException.class);
        wait1.withTimeout(Duration.ofSeconds(10));
        wait1.pollingEvery(Duration.ofSeconds(1));
        //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("p")));


        waitForElementExist(By.cssSelector("p"));
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

