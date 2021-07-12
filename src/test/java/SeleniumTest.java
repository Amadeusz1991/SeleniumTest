import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        WebDriver driver = getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

        //Przechodzimy do okienka z plikami coockies
        //driver.switchTo().frame(0); -> Nie działa mi to teraz, trzeba obczaic to później
        //Znaleźienie przycisku
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div"));// zmieniłem xpath bo ten poniżej nie działał z kursu
        //WebElement agreeButton = driver.findElement(By.xpath("//span[contains(text(),'Ik ga akkoord')]"));
        //Kliknięcie przycisku
        agreeButton.click();
        //Powrót do pierwotnego okna
        driver.switchTo().defaultContent();
        //
        WebElement searchField = driver.findElement(By.name("q"));
        searchField.sendKeys("Selenium");
        searchField.sendKeys(Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//a[contains(@href,'selenium.dev)]//span'"));

        Assert.assertTrue(result.isDisplayed());

    }

    public WebDriver getDriver(String browser){
        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ajankows\\Desktop\\ChromeDriver\\chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajankows\\Desktop\\ChromeDriver\\geckodriver.exe");
                return new FirefoxDriver();
            case "ie":
                System.setProperty("webdriver.ie.driver", "C:\\Users\\ajankows\\Desktop\\ChromeDriver\\IEDriverServer.exe");
                return new InternetExplorerDriver();
            default:
                throw new InvalidArgumentException("Invalid browser name");
        }
    }
}
