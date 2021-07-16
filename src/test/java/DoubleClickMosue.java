import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DoubleClickMosue {

    @Test
    public void doubleClick() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/doubleclick.html");

        // Uzycie dobuleClick na przycisku uzywając metody Actions
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(By.id("bottom"))).perform();
    }
}
