import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.testng.annotations.Test;

public class SeleniumTest {

    @Test
    public void openGooglePage(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\ajankows\\Desktop\\ChromeDriver\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\ajankows\\Desktop\\ChromeDriver\\geckodriver.exe");
        System.setProperty("webdriver.ie.driver", "C:\\Users\\ajankows\\Desktop\\ChromeDriver\\IEDriverServer.exe");
        InternetExplorerOptions options = new InternetExplorerOptions();
        options.withInitialBrowserUrl("https://www.google.com/");
        WebDriver driver = new InternetExplorerDriver(options);
        //driver.get("https://www.google.com/");
    }
}
