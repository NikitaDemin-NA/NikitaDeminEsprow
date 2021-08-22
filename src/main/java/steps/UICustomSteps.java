package steps;

import org.junit.After;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UICustomSteps {
    WebDriver driver;

    public void waitforPageLoad(WebDriver driver){
        new WebDriverWait(driver,30).until(wd ->
                ((JavascriptExecutor) wd).executeScript("{return document.readyState").equals("complete"));
    }


}
