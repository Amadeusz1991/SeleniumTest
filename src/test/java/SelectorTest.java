import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonId = By.id("clickOnMe");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //clickOnMeButton.click();

        By firstName = By.name("fname");
        WebElement inputName = driver.findElement(firstName);
        inputName.click();
        inputName.sendKeys("send");

        By paraHidden = By.className("topSecret");
        driver.findElement(paraHidden);

        //Wyszukiwanie inputa pierwszego w kolejności
        By inputLocator = By.tagName("input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("hello");
        //Wyszukiwanie wszystkich inputów
        List<WebElement> inputs = driver.findElements(inputLocator);
        System.out.println(inputs.size());

        By linkText = By.linkText("Visit W3Schools.com!");
        WebElement link = driver.findElement(linkText);
        //link.click();

        By partialLink = By.partialLinkText("Visit");
        WebElement pLink = driver.findElement(partialLink);
        pLink.click();


    }
}
