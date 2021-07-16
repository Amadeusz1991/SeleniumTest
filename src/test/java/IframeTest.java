import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class IframeTest {


    @Test
    public void testNewWindow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/iframe.html");

        // Przełączanie się do pierwszego dostępnego iframu za pomocą indeksu
        //driver.switchTo().frame(0);

        // Przełączanie się do pierwszego dostępnego iframu za pomocą cssSelektora
        WebElement iframe = driver.findElement(By.cssSelector("[src='basics.html']"));
        driver.switchTo().frame(iframe);

        // Na tej stronie nie da się tego użyc z powodu braku tych wartości na stronie
        //driver.switchTo().frame("wartość id lub wartość name");
        driver.findElement(By.id("fname")).sendKeys("Amadeusz");
        // Powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        System.out.println(driver.findElement(By.tagName("h1")).getText());
    }
}
