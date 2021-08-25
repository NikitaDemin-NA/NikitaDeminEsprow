package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.ru.Если;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PublicKey;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;


public class CustomSteps extends FinalAccount {


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
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        checkSessionsExpired();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = driver.getCurrentUrl();
        if(!url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
            WebElement subscriptionButton = driver.findElement(By.xpath("//a[text()='Subscription']"));
            subscriptionButton.click();

        }
            //Thread.sleep(2000);

        waitforPageLoad(driver);
            if (getElementByXpath(driver, "//h1[text()='Subscription']") == null) {
                throw new Exception("Subscription doesn't open");
            }

            try{
                waitForElementToAppear(driver, "//div[contains(text(),'You don')]", 3);
                quantityOfNewExchanges=0;
            } catch (Exception e){
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//input[@type='checkbox']"));
                quantityOfNewExchanges = checkNewExchanges.size();
                quantityOfNewExchanges--;
            }


    }


    @Given("add {int} new Exchange with {string} Protocol Type and {int} Number of Sessions")
    public void AddNewExchange(int quantityNewEchange, String protocolType, int numAddNewExchange)  throws Exception {
        for (int i = 0; i < quantityNewEchange; i++) {
            this.numAddNewExchange = numAddNewExchange;
            clickAddExchange();
            checkQuantityProtocolType(6);

            WebElement clickProtocolType = driver.findElement(By.xpath("//div/div[text()='"+protocolType+"']"));
            clickProtocolType.click();

            //steps before adding Number of Sessions
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
        }

        //check new Exchange
        String url = driver.getCurrentUrl();
        if(url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
            List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//span[text()='[Exchange not created yet]']"));
            int quantityOfNewExchangesNew = checkNewExchanges.size();

            if (quantityOfNewExchangesNew != quantityOfNewExchanges+quantityNewEchange) {
                throw new Exception("New Exchange didn't create");
            }
        }
    }


    @Given("check Final Account")
    public void checkFinalAccount() throws Exception {
        checkProtocolTypeFinalAccount();
        checkMounthlySubcriptionFinalAccount();
        checkCurrentPaymentFinalAccount();
    }

    @Given("pay for the Exchanges")
    public void payForTheExchange() throws Exception {
        clickPayButton();
        checkValueOfExchangePO();
        checkValueOfSessionsPO();



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
