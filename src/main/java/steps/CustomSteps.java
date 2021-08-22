package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Если;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;
import java.util.concurrent.TimeUnit;


public class CustomSteps extends UICustomSteps {


    @Given("open page")
    public void startBrowserInMacOrWindows() {
        String os = System.getProperty("os.name");
        String arch = System.getProperty("os.arch");
        if (os.contains("Windows"))
            getPageInWindows();
        else if (os.contains("Mac OS"))
            getPageInMac();
        else if (os.contains("Mac OS") && arch.contains("aarch64"))
            getPageInMacM1();
    }


    @Given("check page title")
    public void getTitle() throws Exception {
        waitforPageLoad(driver);
        try {
            WebElement title = driver.findElement(By.xpath("//title"));
            System.out.println(title.getText());
            if (title.getText().contains("ETP Markets")) {
            }
        } catch (Exception e) {
            throw new Exception("Main page doesn't open");
        }
    }


    @Given("sign in with login = {string} and password = {string}")
    public void logIn(String emailField, String passwordField) throws Exception {
        clickSignIn();
        checkAuthorizationPage();
        setEmail(emailField);
        setPassword(passwordField);
        authorizationButton();
    }

    @Given("open Subscription page")
    public void openSubcirption() throws Exception {
        WebElement login = driver.findElement(By.xpath("//span/img[@alt='user image']//following-sibling::div"));
        login.click();
        WebElement subscriptionButton = driver.findElement(By.xpath("//a[text()='Subscription']"));
        subscriptionButton.click();

        waitforPageLoad(driver);
        if (getElementByXpath(driver, "//h1[text()='Subscription']") == null) {
            throw new Exception("Subscription doesn't open");
        }
    }


    @Given("close browser")
    public void tearDown() {
        driver.quit();
    }

}
