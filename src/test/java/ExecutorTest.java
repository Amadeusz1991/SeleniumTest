import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ExecutorTest {

    @Test
    public void executeJavaScript() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium");

        WebElement basicPagelink = driver.findElement(By.linkText("Podstawowa strona testowa"));

        // stworzenie JavascriptExecutor i przypisanie go do interfejsu, potem z castowanie drivera do javascriptexe
        JavascriptExecutor executor = (JavascriptExecutor) driver;

        //Wywołanie metody click na elemencie
        executor.executeScript("arguments[0].click();", basicPagelink);

        WebElement firstName = driver.findElement(By.name("fname"));
        // Dodanie wartości do inputu za pomocą JavaScript. Metoda zamiast sendKeys
        executor.executeScript("arguments[0].setAttribute('value', 'Amadeusz');", firstName);

        //WebElement chooseFile = driver.findElement(By.id("myFile"));

    }
}
