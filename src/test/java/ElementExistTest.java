import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.ScheduledExecutorService;

public class ElementExistTest {

    WebDriver driver;

    @Test
    public void elementExistTest () {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");
        System.out.println(elementExist(By.tagName("p")));
        System.out.println(elementExist(By.id("topSecret")));

        System.out.println(elementExistSecond(By.tagName("p")));
        System.out.println(elementExistSecond(By.id("topSecret")));

        //Sprawdzanie czy element jest wyswietlony na ekranie
        System.out.println(driver.findElement(By.tagName("p")).isDisplayed());
        System.out.println(driver.findElement(By.tagName("button")).isDisplayed());

        // Sprawdzenie czy element jest dostępny
        System.out.println(driver.findElement(By.tagName("button")).isEnabled());
        System.out.println("Czy zaznaczony jest checkbox?");

        // sprawdzenie czy checkbox został zaznaczony
        WebElement checkbox = driver.findElement(By.cssSelector("[type='checkbox']"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());

    }
    // Metoda która sprawdza czy dany element istnieje lub nie
    public boolean elementExist(By locator) {
        try {
            driver.findElement(locator);
            return  true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
    /*  Inny sposób na sprawdzenie, czy element istnieje czy tez nie.
     Wyszukanie listy elementów i sprawdzenie czy ta lista jest większa od 0.
    Jeżeli jest = 0 to ta lista będzie false, jak większa niż 0 to znaczy, ze istnieje */
    public boolean elementExistSecond(By locator) {

        return driver.findElements(locator).size() > 0;
    }

}
