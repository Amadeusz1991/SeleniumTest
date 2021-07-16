import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

public class ScreenshotTest {

    @Test
    public void screenshotTest() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/fileupload.html");

        // Stworzenie generatora randomowych liczb
        int randomNumber = (int) (Math.random()*1000);

        // Tworzenie screenshota po wykonanym teście bez nadpisywania starych screenów
        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File uploadFile = screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "uploadFile" + randomNumber + ".png";
        FileUtils.copyFile(uploadFile, new File("src/test/resources/" + fileName));

        // Dodawanie pliku za pomocą ściezki docelowej pliku na dysku
        WebElement chooseFile = driver.findElement(By.id("myFile"));
        chooseFile.sendKeys("C:\\Users\\ajankows\\Desktop\\Capture 3.PNG");




        

    }
}
