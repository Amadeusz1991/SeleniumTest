import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class BasecActionsTest {


    @Test
    //metoda
    public void performAction(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium");

        WebElement basicPagelink = driver.findElement(By.linkText("Podstawowa strona testowa"));
        System.out.println(basicPagelink.getText());
        basicPagelink.click();
        driver.findElement(By.id("fname")).sendKeys("Amadeusz");
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.clear();
        usernameInput.sendKeys("Admin");

        // Pobieranie wartości z pola text do konsoli
        System.out.println(usernameInput.getAttribute("value"));
        usernameInput.sendKeys(Keys.ENTER);

        // obsłużenie wyskakującego allertu
        Alert firstAlert = driver.switchTo().alert();
        firstAlert.accept();
        // drugi alert także został obsłuzony
        driver.switchTo().alert().accept();


        driver.findElement(By.cssSelector("[type='checkbox']")).click();
        driver.findElement(By.cssSelector("[value='male']")).click();

        // select do używania dropdowna i wyboru poszcezgólnych opcji
        WebElement selectCar = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCar);
        //cars.selectByIndex(2);
        //cars.selectByVisibleText("Saab");
        cars.selectByValue("volvo");

        //Pętla wypisuje wszystkie auta dostępne w dropdownie
        List<WebElement> options = cars.getOptions();
        for(WebElement option : options) {
            System.out.println(option.getText());
        }

        //Odwołanie do metody SelectCheck i porównanie czy opcja tekstowa zgadza się z prawdziwą na stronie
        SelectCheck selectCheck = new SelectCheck();
        System.out.println(selectCheck.checkOption("Audi", selectCar));
        System.out.println(selectCheck.checkOption("Jeep", selectCar));

        //Aby uzyskać ukryty tekst, trzeba użyć opcji "textContent".
        WebElement hiddenParagraph = driver.findElement(By.cssSelector(".topSecret"));
        System.out.println("By text:" + hiddenParagraph.getText());
        System.out.println("By attribute value:" + hiddenParagraph.getAttribute("value"));
        System.out.println("By attribute content:" + hiddenParagraph.getAttribute("textContent"));



    }
}
