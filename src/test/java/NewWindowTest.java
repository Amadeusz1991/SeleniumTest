import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.util.Set;

public class NewWindowTest {


    @Test
    public void testNewWindow() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // Tworzymy nazwę okna pierwotnego. getWindowHandle() zwraca nam Stringa
        String currentWindow = driver.getWindowHandle();
        // Otwieramy zaraz nowe okno po kliknięciu elementu
        driver.findElement(By.id("newPage")).click();
        // Zbieramy zbiór wszystkich dostępnych okien
        Set<String> windowNames = driver.getWindowHandles();
        // sprawdzanie czy nazwa jest różna od nazwy obecnego okna, jeżeli tak, to wchodzimy do tego nowego okna
        for(String window : windowNames){ // dla każdego elementu String window, znajdującego się w zbiorze windowNames
            if (!window.equals(currentWindow)){ // Sprawdzamy czy, window jest rózna od obecnego okna
                driver.switchTo().window(window); // jeżeli tak to przełączamy się do tego okna.
            }
        }

        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click(); // zamykam pliki coockie
        driver.findElement(By.name("q")).sendKeys("Selenium");
        driver.switchTo().window(currentWindow); // przełączamy się z powrotem do okna pierwotnego aby wykonać kod poniżej
        driver.findElement(By.name("fname")).sendKeys("Amadeusz");
    }
}
