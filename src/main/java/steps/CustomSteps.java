package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Если;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.List;
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
        String url = driver.getCurrentUrl();
        if(!url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
            WebElement subscriptionButton = driver.findElement(By.xpath("//a[text()='Subscription']"));
            subscriptionButton.click();
            waitforPageLoad(driver);
            //Thread.sleep(2000);
            if (getElementByXpath(driver, "//h1[text()='Subscription']") == null) {
                throw new Exception("Subscription doesn't open");
            }
        }
    }


    @Given("click on \"Add Exchange\" button")
    public void clickAddExchange() throws Exception {
        WebElement test = driver.findElement(By.xpath("//div[text()='TRIAL']"));
        test.click();
        WebElement clickAddExchangeButton = driver.findElement(By.xpath("//button[text()='Add Exchange']"));
        clickAddExchangeButton.click();
        if(getElementByXpath(driver,"//h2[text()='Add New Exchange']") == null){
            throw new Exception("pop-up window \"Add New Exchange\" doesn't open");
        }
    }

    @Given("add new Exchange with {int} Number of Sessions")
    public void AddNewExchange(int numAddNewExchange) throws Exception {
        this.numAddNewExchange = numAddNewExchange;
        WebElement chooseProtocolType = driver.findElement(By.xpath("//div/div[text()='Protocol type']/parent::div/input"));
        chooseProtocolType.click();

        //steps before adding Number of Sessions
        checkQuantityProtocolType();
        checkNumberOfSessions();
        checkNumberOfProtocol("$50.0");
        checkNumberOfSessions("$0.0");
        checkNumberOfTotal("$50.0");
        //click on "+" button
        clickOnPlusButton(numAddNewExchange);

        //steps after adding Number of Sessions
        checkNewNumberOfSessions(numAddNewExchange);
        checkNewNumberOfTotal(numAddNewExchange);

        //click on "Add" button
        clickOnAddButton();

        //check new Exchange
        String url = driver.getCurrentUrl();
        if(url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
            List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//span[text()='[Exchange not created yet]']"));
            int quantityOfNewExchanges = checkNewExchanges.size();

            if (quantityOfNewExchanges != 1) {
                throw new Exception("New Exchange didn't create");
            }
        }
    }


    @Given("wait {long} seconds")
    public void waitSecond(long seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }


    @Given("close browser")
    public void tearDown() {
        driver.quit();
    }

}
