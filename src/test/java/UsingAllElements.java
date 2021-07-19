import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UsingAllElements {

    @Test
    public void usingAllElements() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText());

        driver.findElement(By.id("clickOnMe")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        driver.findElement(By.cssSelector("[name='fname']")).sendKeys("Amadeusz");

        //Otworzenie strony w nowej karcie a potem przejście z powrotem do pierwotnej strony
        String selectLinkW3 = Keys.chord(Keys.CONTROL,Keys.RETURN);
        driver.findElement(By.linkText("Visit W3Schools.com!")).sendKeys(selectLinkW3);
        String handle=driver.getWindowHandle();//get handle of parent window
        Set<String> handles = driver.getWindowHandles();//get all window handles
        for(String han:handles){
            if(!han.equals(handle)) {
            driver.switchTo().window(han);
            }
        }
        driver.switchTo().window(handle);

        //Otworzenie drugiej strony w nowej karcie a potem przejście z powrotem do pierwotnej strony
        String selectLinkIam = Keys.chord(Keys.CONTROL, Keys.RETURN);
        driver.findElement(By.linkText("IamWeirdLink")).sendKeys(selectLinkIam);
        String handle1=driver.getWindowHandle();//get handle of parent window
        Set<String> handles1 = driver.getWindowHandles();//get all window handles
        for(String han:handles1){
            if(!han.equals(handle)) {
                driver.switchTo().window(han);
            }
        }
        driver.switchTo().window(handle1);

        //Wypisanie w konsoli wartości wyświetlonej w tabeli
        WebElement headerMonthSavings = driver.findElement(By.xpath("//tr[1]"));
        System.out.println(headerMonthSavings.getText());
        WebElement monthSavingValue = driver.findElement(By.xpath("//tr[2]"));
        System.out.println(monthSavingValue.getText());

        // Wybranie wartości w dropdownie
        WebElement selectCars = driver.findElement(By.cssSelector("select"));
        Select cars = new Select(selectCars);
        cars.selectByValue("mercedes");

        // kliknięcie checkboxa
        driver.findElement(By.xpath("(//input)[2]")).click();
        // Wybranie radiobuttona
        driver.findElement(By.cssSelector("[value='male']")).click();

        // wyczyszczenie danych w inputach i dodanie własnych + submit
        WebElement userName = driver.findElement(By.name("username"));
        userName.clear();
        userName.sendKeys("Amadeusz");
        WebElement password = driver.findElement(By.name("password"));
        password.clear();
        password.sendKeys("12345");
        driver.findElement(By.cssSelector("[value='Submit']")).click();

        // wyłączenie popupu po submicie, który trzeba potwiercic dwukrotnie
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        driver.switchTo().alert().accept();

        //Klikniecie w przycisk pod obrazkiem i zamknięcie nowej przeglądarki
        driver.findElement(By.id("newPage")).click();
        String handle2 = driver.getWindowHandle();
        Set<String> handles2 = driver.getWindowHandles();
            for (String han : handles2)
                if (!han.equals(handle2)) {
                    driver.switchTo().window(han);
                }
        driver.close();
                // Przełączam sie do pierwszej zakładki w przeglądarce
                ArrayList<String> tab2 = new ArrayList<String>(driver.getWindowHandles());
                driver.switchTo().window(tab2.get(0));

        WebElement childItem = driver.findElement(By.cssSelector("li > ul"));
        System.out.println(childItem.getText());










    }
}
