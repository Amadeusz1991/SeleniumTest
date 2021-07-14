import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class XpathTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        By buttonId = By.xpath("//button[@id='clickOnMe']");
        WebElement clickOnMeButton = driver.findElement(buttonId);
        //clickOnMeButton.click();

        By firstName = By.xpath("//input[@name='fname']");
        WebElement inputName = driver.findElement(firstName);
        inputName.click();
        inputName.sendKeys("send");

        By paraHidden = By.xpath("//p[@class='topSecret']");
        driver.findElement(paraHidden);

        //Wyszukiwanie inputa pierwszego w kolejności
        By inputLocator = By.xpath("//input");
        WebElement input = driver.findElement(inputLocator);
        input.sendKeys("Pierwszy");
        List<WebElement> inputs = driver.findElements(inputLocator);    //Wyszukiwanie wszystkich inputów
        System.out.println(inputs.size());

        By linkText = By.xpath("//a[text()='Visit W3Schools.com!']"); // wyszukiwanie xpath uzywając całego tekstu
        WebElement link = driver.findElement(linkText);
        //link.click();

        By partialLink = By.xpath("//a[contains(text(),'Visit')]"); // wyszukiwanie xpath używając kawałka tekstu
        WebElement pLink = driver.findElement(partialLink);
        //pLink.click();

        By fullPath = By.xpath("/html/body/div/ul");
        By shortPath = By.xpath("//ul");
        By allXpath = By.xpath("//*");
        By secondElement = By.xpath("(//input)[2]");
        By lastElement = By.xpath("(//input)[last()]");

        driver.findElements(fullPath);
        driver.findElement(shortPath);
        driver.findElement(allXpath);
        driver.findElement(secondElement);
        driver.findElement(lastElement);


        By elementWithAttribute = By.xpath("//*[@name]");
        By attributeEquals = By.xpath("//button[@id='clickOnMe']");
        By attributeNotEquals = By.xpath("//button[@id!='clickOnMe']");
        By attributeContains = By.xpath("//*[contains(@name,'name')]");
        By startsWith = By.xpath("//*[starts-with(@name,'u')]");
        By endsWith = By.xpath("//*[substring(@name,string-length(@name)-string-length('ame')+1)='ame']");

        driver.findElement(elementWithAttribute);
        driver.findElement(attributeEquals);
        driver.findElement(attributeNotEquals);
        driver.findElement(attributeContains);
        driver.findElement(startsWith);
        driver.findElement(endsWith);


        By child = By.xpath("//div/child::ul"); // Wejście do pierwszego zagnieżdżenia znacznika Div
        By descendant = By.xpath("//div/descendant::ul"); // Wejście do wszystkich tagów ul wewnątrz diva
        By ancestor = By.xpath("//div/ancestor::*"); // Wszystkie tagi nad tagiem div
        By following = By.xpath("//img/following::*"); // Wszystkie tagi które następuja po obrazku
        By followingSibling = By.xpath("//img/following-sibling::*"); // Wszystkie tagi które znajdują się na tym samym poziomie co obrazek
        By preceding = By.xpath("//img/preceding::*"); // Wszystkie tagi które są przed img
        By precedingSibling = By.xpath("//img/preceding-sibling::*"); // Wszystkie tagi  które są w tej samej strukturze co img

        driver.findElements(child);
        driver.findElements(descendant);
        driver.findElements(ancestor);
        driver.findElement(following);
        driver.findElement(followingSibling);
        driver.findElements(preceding);
        driver.findElements(precedingSibling);

        By divsAndLinks = By.xpath("//a | //input"); //Wyszukanie dwóch tagów naraz
        By andOperation = By.xpath("//input[@name='fname' and @id='fname']"); // Wyszukanie warunkowe, oba muszą się zgadzać
        By orOperation = By.xpath("//input[@name='fname' or @id='fname']"); // Wyszukanie warunkowe, gdzie tylko jeden może być poprawny

        driver.findElement(divsAndLinks);
        driver.findElement(andOperation);
        driver.findElement(orOperation);

        

    }
}
