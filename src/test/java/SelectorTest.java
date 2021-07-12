import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        //clickOnMe
        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        clickOnMeButton.click();
    }
}
