import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class RightClickMosue {

    @Test
    public void rightClick() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");


        // Kliknięcie prawym przyciskiem myszy na tle przeglądarki
        Actions actions = new Actions(driver);
        actions.contextClick().perform();

        // Użycie prawego przycisku na wybranym elemencie
        Actions actions1 = new Actions(driver);
        actions1.contextClick(driver.findElement(By.id("myFile"))).perform();
    }
}
