package steps;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UICustomSteps {
    WebDriver driver;

    public void waitforPageLoad(WebDriver driver){
        new WebDriverWait(driver,30).until(wd ->
                ((JavascriptExecutor) wd).executeScript("{return document.readyState").equals("complete"));
    }

    public WebElement getElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            try {
                return driver.findElement(By.xpath(xpath));
            } catch (Exception e){
                Thread.sleep(3000);
            }
        }
        return null;
    }


}
