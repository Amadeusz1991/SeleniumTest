import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CssSelectorTest {

    @Test
    public void findElements(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testeroprogramowania.github.io/selenium/basics.html");

        // Wyszukiwanie ID za pomocą css selektora, zawsze daje się # najpierw a potem wartość ID
        // Sprawdzanie w konsoli czy istnieje taki selektor $$("#clickOnMe")
        By cssId = By.cssSelector("#clickOnMe");
        driver.findElement(cssId);

        //Wyszukiwanie klasy za pomocą css selektora, zaczynamy od "kropki" a potem wartość
        By cssClass = By.cssSelector(".topSecret");
        driver.findElement(cssClass);

        By cssTag = By.cssSelector("input");
        driver.findElement(cssTag).sendKeys("pierwszy");

        // W tym przypadku trzeba uzywać pełnego atrybutu name nie tylko jego wartość.
        // $$("[name='fname']")
        By cssName = By.cssSelector("[name='fname']");
        driver.findElement(cssName);

        //$$("[class='topSecret']")
        By cssClass2 = By.cssSelector("[class='topSecret']");
        driver.findElement(cssClass2);

        By all = By.cssSelector("*");
        driver.findElement(all);

        //Dojście do elementów "Child" wewnątrz div,table etc. W ten sposób zawsze wybrany jest pierwszy od góry child.
        By ulInsideDiv = By.cssSelector("div ul");
        By trInTable = By.cssSelector("table tr");
        By trInBody = By.cssSelector("tbody tr");
        driver.findElement(ulInsideDiv);
        driver.findElement(trInTable);
        driver.findElements(trInBody);

        By firstChildUlInDiv = By.cssSelector("div > ul");
        By firstChildTrInTbody = By.cssSelector("tbody > tr");
        driver.findElement(firstChildUlInDiv);
        driver.findElement(firstChildTrInTbody);

        //Nazwy zmiennych sugerują wynik wyszukiwnia elementu
        By firstFormAfterLabel = By.cssSelector("label + form");
        By allFormsAfterLabel = By.cssSelector("label ~ form");
        driver.findElement(firstFormAfterLabel);
        driver.findElement(allFormsAfterLabel);

        By attributeTag = By.cssSelector("input[name='fname']");
        By attributeContains = By.cssSelector("[name*= 'name']");
        By attributeStarts = By.cssSelector("[name^= 'f']");
        By attributeEnds = By.cssSelector("[name$= 'name']");
        driver.findElement(attributeTag);
        driver.findElement(attributeContains);
        driver.findElement(attributeStarts);
        driver.findElement(attributeEnds);

        //Wyszukiwanie elementów z list, "nth" uzywa się w momencie gdy chcemy wybrać konkretny element z listy
        By firstChild = By.cssSelector("li:first-child");
        By lastChild = By.cssSelector("li:last-child");
        By thirdChild = By.cssSelector("li:nth-child(3)");
        driver.findElement(firstChild);
        driver.findElement(lastChild);
        driver.findElement(thirdChild);

        //rename


    }
}
