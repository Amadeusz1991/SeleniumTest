import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectCheck {

        // Metoda sprawdza czy parametr String jest jedną z opcji w Select
    public boolean checkOption(String optionText, WebElement element) {
        Select select = new Select(element);
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(optionText))
                return true;
        }
        return false;
    }
}
