package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class UICustomSteps {
    WebDriver driver;
    String emailField;
    int numAddNewExchange;
    int quantityOfNewExchanges;
    int quantityOfTypeSubscriptionInt;
    int quantityOfTypeFinalAccountCPInt;
    int quantityOfPaidTypeFinalAccountMSInt;


    public void getPageInWindows() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_Windows.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void getPageInMac() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_Mac");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void getPageInMacM1() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_M1");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void waitforPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until(wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


    public WebElement getElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            try {
                return driver.findElement(By.xpath(xpath));
            } catch (Exception e) {
                Thread.sleep(3000);
            }
        }
        return null;
    }

    public List<WebElement> getElementsByXpath(WebDriver driver, String xpath) throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            try {
                return driver.findElements(By.xpath(xpath));
            } catch (Exception e) {
                Thread.sleep(3000);
            }
        }
        return null;
    }


    public void checkAuthorizationPage() throws Exception {
        waitforPageLoad(driver);
        if (getElementByXpath(driver, "//h2[text()='Log in to ETP Markets']") == null) {
            throw new Exception("Log In page doesn't open");
        }
    }


    public void clickSignIn() {
        WebElement SignIn = driver.findElement(By.xpath("//a[@href='/auth/sign-in']"));
        SignIn.click();
    }


    public void setEmail(String emailField) {
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.clear();
        this.emailField = emailField;
        email.sendKeys(emailField);
    }


    public void setPassword(String passwordField) {
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.clear();
        password.sendKeys(passwordField);
    }

    public void clickLoginButton() {
        WebElement login = driver.findElement(By.xpath("//span/img[@alt='user image']//following-sibling::div"));
        login.click();
    }


    public void authorizationButton() throws Exception {
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign In']"));
        signin.click();

        for (int i = 0; i < 1; i++) {
            try {
                String url = driver.getCurrentUrl();
                if (url.equals("https://spa-dev.etpmarkets.com:3000/app/subscription")) {
                } else if (url.equals("https://spa-dev.etpmarkets.com:3000/app/exchange")) {
                }
            } catch (Exception e) {
                Thread.sleep(3000);
            }
        }

        try {
            //login on top of the right corner
            clickLoginButton();
            String login = getElementByXpath(driver, "//span/img[@alt='user image']//following-sibling::div").getText();
            //login on left side of site
            String loginName = getElementByXpath(driver, "//p[text()='" + this.emailField + "']/parent::div/p[1]").getText();
            if (login.equals(loginName)) {
            }
        } catch (Exception e) {
            throw new Exception("Log In is not correct");
        }
    }


    //check a quantity of Protocol Type
    public void checkQuantityProtocolType(int quantityOfProtocolType) throws Exception {
        WebElement chooseProtocolType = driver.findElement(By.xpath("//div/div[text()='Protocol type']/parent::div/input"));
        chooseProtocolType.click();

        List<WebElement> findquantityProtocolType = getElementsByXpath(driver, "//div/div[contains(text(),'FIX')]");
        int quantityProtocolType = findquantityProtocolType.size();
        if (quantityProtocolType != quantityOfProtocolType) {
            throw new Exception("A quantity of Protocol Type is not correct");
        }
    }


    //check number of sessions
    public void checkNumberOfSessions() throws Exception {
        String numberOfSessions = getElementByXpath(driver, "//div/span[text()='Number of Sessions']/following-sibling::div/div[2]").getText();

        if (!numberOfSessions.equals("0")) {
            throw new Exception("number of Sessions is not \"0\"");
        }
    }


    //click on "+" button
    public void clickOnPlusButton(int numAddNewExchange) {
        for (int i = 0; i < numAddNewExchange; i++) {
            WebElement clickPlusButton = driver.findElement(By.xpath("(//*[text()='Add New Exchange']/parent::div/div/div/div)[last()]/*[name()='svg']/*[name()='line']/parent::*[name()='svg']/parent::div"));
            clickPlusButton.click();
        }
    }


    //check value of protocol
    public void checkNumberOfProtocol(String numberOfProt) throws Exception {
        String numberOfProtocol = getElementByXpath(driver, "//div/span[text()='Protocol:']/following-sibling::span").getText();

        if (!numberOfProtocol.equals(numberOfProt)) {
            throw new Exception("value of Protocol is not " + numberOfProt);
        }
    }


    //check value of sessions
    public void checkNumberOfSessions(String numberOfSess) throws Exception {
        String numberOfSessions = getElementByXpath(driver, "(//div/span[text()='Sessions:']/following-sibling::span)[last()]").getText();

        if (!numberOfSessions.equals(numberOfSess)) {
            throw new Exception("value of Sessions is not " + numberOfSess);
        }
    }

    //check new value of sessions
    public void checkNewNumberOfSessions(int numAddNewExchange) throws Exception {
        this.numAddNewExchange = numAddNewExchange;
        String numberOfSessions = getElementByXpath(driver, "(//div/span[text()='Sessions:']/following-sibling::span)[last()]").getText();
        String parseNumberOfSessions = numberOfSessions.replaceAll("[^0-9]", "");

        if (Integer.parseInt(parseNumberOfSessions) != numAddNewExchange * 100) {
            throw new Exception("value of Sessions is not $" + numAddNewExchange * 10 + ".0");
        }
    }


    //check value of total
    public void checkNumberOfTotal(String numberOfTot) throws Exception {
        String numberOfTotal = getElementByXpath(driver, "//div/span[text()='Total cost:']/following-sibling::span").getText();

        if (!numberOfTotal.equals(numberOfTot)) {
            throw new Exception("value of Sessions is not " + numberOfTot);
        }
    }

    //check new value of total
    public void checkNewNumberOfTotal(int numAddNewExchange) throws Exception {
        this.numAddNewExchange = numAddNewExchange;
        String numberOfTotal = getElementByXpath(driver, "//div/span[text()='Total cost:']/following-sibling::span").getText();
        String parseNumberOfTotal = numberOfTotal.replaceAll("[^0-9]", "");


        if (Integer.parseInt(parseNumberOfTotal) != 500 + (numAddNewExchange * 100)) {
            throw new Exception("value of Total is not $" + (500 + (numAddNewExchange * 100)) + ".0");
        }
    }


    //click on "Add" button
    public void clickOnAddButton() {
        WebElement clickAddButton = driver.findElement(By.xpath("//div/button[text()='Add']"));
        clickAddButton.click();
    }


    //click on "Add Exchange" button"
    public void clickAddExchange() throws Exception {
        WebElement test = driver.findElement(By.xpath("//div[text()='TRIAL']"));
        test.click();
        WebElement clickAddExchangeButton = driver.findElement(By.xpath("//button[text()='Add Exchange']"));
        clickAddExchangeButton.click();
        if (getElementByXpath(driver, "//h2[text()='Add New Exchange']") == null) {
            throw new Exception("pop-up window \"Add New Exchange\" doesn't open");
        }
    }


    //Explicit Wait
    public static void waitForElementToAppear(WebDriver driver, String selector, long timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        WebElement a = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }


}





