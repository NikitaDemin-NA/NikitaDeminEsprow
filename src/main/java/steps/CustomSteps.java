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
        checkSessionsExpired();

    }


    @Given("open Subscription page")
    public void openSubcirption() throws Exception {

        WebElement testButton = driver.findElement(By.xpath("//span[text()='test']"));
        testButton.click();
        WebElement subscriptionButton = driver.findElement(By.xpath("//a[text()='Subscription']"));
            subscriptionButton.click();
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

            WebElement clickProtocolType = driver.findElement(By.xpath("//div/div[text()='" + protocolType + "']"));
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
        if (url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
            List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//span[text()='[Exchange not created yet]']"));
            int quantityOfNewExchangesNew = checkNewExchanges.size();

            //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            //take a quantity of PAID values Protocol Type in list of Subscription
            List<WebElement> quantityOfPaidTypeFinalAccountMS = getElementsByXpath(driver, "//*[text()='Paid']");
            quantityOfPaidTypeFinalAccountMSInt = quantityOfPaidTypeFinalAccountMS.size();

            quantityOfNewExchanges = 1;
            if (quantityOfNewExchangesNew-quantityOfPaidTypeFinalAccountMSInt == quantityOfNewExchanges * quantityNewEchange) {
                quantityOfNewExchanges = 0;
            } else {
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
        //checkValueOfExchangePO();
        //checkValueOfSessionsPO();
        checkPayNowOrder();
        checkNextChargeOrder();
        clickCheckout();
        checkPayNowCheckout();
        checkNextChargeCheckout();
        clickAgree();
        checkSuccessOfPay();
    }

    @Given("delete all Exchanges")
    public void deleteAllEchanges() throws Exception {
        if(quantityOfNewExchanges!=0){
            WebElement checkboxDeleteAllExchanges = driver.findElement(By.xpath("(//input [@type='checkbox' and @value='false'])[1]/../parent::div"));
            checkboxDeleteAllExchanges.click();

            if(getTrueExchanges()){
                WebElement deleteAllExchanges = driver.findElement(By.xpath("//*[name()='svg' and @data-tip='Delete selected subscriptions']"));
                deleteAllExchanges.click();

                //checkFinalAccount
                if(iGetMS!=0 && iGetCP!=0){
                    throw new Exception("values of Final Account is not \"$0\"");
                }

                WebElement clickConfirmButton = driver.findElement(By.xpath("//button[text()='Confirm']"));
                clickConfirmButton.click();
                WebElement clickConfirmButtonAttention = driver.findElement(By.xpath("(//div[contains(text(),'ATT')]/../div)[3]/button[text()='Confirm']"));
                clickConfirmButtonAttention.click();
                waitForElementToAppear(driver, "//div[contains(text(),'You don')]", 3);
            } else {
                throw new Exception("trouble with \"Delete all Exchanges \" button");
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
