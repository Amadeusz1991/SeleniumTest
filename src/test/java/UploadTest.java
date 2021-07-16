import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UploadTest {

    @Test
    public void uploadFile() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // Dodawanie pliku za pomocą ściezki docelowej pliku na dysku
        WebElement chooseFile = driver.findElement(By.id("myFile"));
        chooseFile.sendKeys("C:\\Users\\ajankows\\Desktop\\Capture 3.PNG");

        

    }
}
