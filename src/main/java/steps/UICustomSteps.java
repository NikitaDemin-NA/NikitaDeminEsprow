package steps;

import org.openqa.selenium.*;
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
    int totalPriceMS = 0;
    int totalPriceSessionsMS = 0;
    int totalAddPriceSessionsMS = 1;
    int totalQuantityExchangePO = 0;
    int totalQuantitySessionsPO = 0;
    int iGetCP;
    int iGetMS;
    int iAddExtraPriceSessionsListSubscription;


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
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(selector)));
    }


    //click payButton
    public void clickPayButton() throws Exception {
        WebElement payButton = driver.findElement(By.xpath("//button[contains(text(),'Pay')]"));
        payButton.click();

        try {
            for (int i = 0; i < 20; i++) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                waitForElementToAppear(driver, "//h1[contains(text(),'Your order')]", 20);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            Thread.sleep(1000);
        }

    }

    //find Quantity of Exchange Price Order
    public void checkValueOfExchangePO() throws Exception {
        List<WebElement> findQuantityExchangePriceOrder = getElementsByXpath(driver, "//h2[contains(text(),'Exchange')]/../h2/span[contains(text(),'$')]");
        int iFindquantityExchangePriceOrder = findQuantityExchangePriceOrder.size();

        for (int i = 1; i <= iFindquantityExchangePriceOrder; i++) {
            String getEchangePriceOrder = getElementByXpath(driver, "(//h2[contains(text(),'Exchange')]/../h2/span[contains(text(),'$')])[" + i + "]").getText();
            String eGetEchangePriceOrder = getEchangePriceOrder.replaceAll("[^0-9]", "");
            int iGetEchangePriceOrder = Integer.parseInt(eGetEchangePriceOrder);
            totalQuantityExchangePO = iGetEchangePriceOrder + totalQuantityExchangePO;
        }
        if (totalPriceMS != totalQuantityExchangePO / 10) {
            throw new Exception("Prices of Exchange in \"Your Order\" is not correct");
        }
    }

    //find Quantity of Sessions Price Order
    public void checkValueOfSessionsPO() throws Exception {
        List<WebElement> findQuantitySessionsPriceOrder = getElementsByXpath(driver, "//h2[contains(text(),'Session')]/../h2/span[contains(text(),'$')]");
        int iFindquantitySessionsPriceOrder = findQuantitySessionsPriceOrder.size();

        for (int i = 1; i <= iFindquantitySessionsPriceOrder; i++) {
            String getSessionsPriceOrder = getElementByXpath(driver, "(//h2[contains(text(),'Session')]/../h2/span[contains(text(),'$')])[" + i + "]").getText();
            String eGetSessionsPriceOrder = getSessionsPriceOrder.replaceAll("[^0-9]", "");
            int iGetSessionsPriceOrder = Integer.parseInt(eGetSessionsPriceOrder);
            totalQuantitySessionsPO = iGetSessionsPriceOrder + totalQuantitySessionsPO;
        }
        if ((totalPriceSessionsMS * totalAddPriceSessionsMS) != totalQuantitySessionsPO * 10) {
            throw new Exception("Prices of Exchange in \"Your Order\" is not correct");
        }
    }

    public void checkSessionsExpired() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        try {
            WebElement clickOK = driver.findElement(By.xpath("//button[text()='Remove']"));
            clickOK.click();
        } catch (Exception e) {
        }
    }


    public void checkPayNowOrder() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitForElementToAppear(driver, "//div/span[text()='Pay now']/../following-sibling::div", 10);
        String getPayNowOrder = getElementByXpath(driver, "//div/span[text()='Pay now']/../following-sibling::div").getText();
        String eGetPayNowOrder = getPayNowOrder.replaceAll("[^0-9]", "");
        int iGetPayNowOrder = Integer.parseInt(eGetPayNowOrder);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (iGetPayNowOrder != iGetCP) {
            throw new Exception("value of \"Pay Now\" button is not correct");
        }
    }

    public void checkNextChargeOrder() throws Exception {
        String getNextChargeOrder = getElementByXpath(driver, "//div/span[contains(text(),'Next charge')]/../following-sibling::div").getText();
        String eGetNextChargeOrder = getNextChargeOrder.replaceAll("[^0-9]", "");
        int iGetNextChargeOrder = Integer.parseInt(eGetNextChargeOrder);

        if (iGetNextChargeOrder != iGetMS * 10) {
            throw new Exception("value of \"Next Charge\" button is not correct");
        }
    }

    public void clickCheckout() throws Exception {
        WebElement clickCheckoutButton = driver.findElement(By.xpath("//span[contains(text(),'Checkout')]"));
        clickCheckoutButton.click();

        try {
            for (int i = 0; i < 20; i++) {
                driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
                waitForElementToAppear(driver, "//h1[contains(text(),'Complete your order')]", 20);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        } catch (Exception e) {
            Thread.sleep(1000);
        }
    }

    public void checkPayNowCheckout() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitForElementToAppear(driver, "//div/span[text()='Pay now']/../following-sibling::div", 10);
        String getPayNowChekout = getElementByXpath(driver, "//div/span[text()='Pay now']/../following-sibling::div").getText();
        String eGetPayNowCheckout = getPayNowChekout.replaceAll("[^0-9]", "");
        int iGetPayNowCheckout = Integer.parseInt(eGetPayNowCheckout);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        if (iGetPayNowCheckout != iGetCP) {
            throw new Exception("value of \"Pay Now\" button is not correct");
        }
    }

    public void checkNextChargeCheckout() throws Exception {
        String getNextChargeCheckout = getElementByXpath(driver, "//div/span[contains(text(),'Next charge')]/../following-sibling::div").getText();
        String eGetNextChargeCheckout = getNextChargeCheckout.replaceAll("[^0-9]", "");
        int iGetNextChargeCheckout = Integer.parseInt(eGetNextChargeCheckout);

        if (iGetNextChargeCheckout != iGetMS * 10) {
            throw new Exception("value of \"Next Charge\" button is not correct");
        }
    }

    public void clickEditPayment() {
        WebElement clickEditPaymentButton = driver.findElement(By.xpath("//div[contains(text(),'Payment')]/../following-sibling::div/div[contains(text(),'Edit')]"));
        clickEditPaymentButton.click();
    }

    public void fillFields(String errorNumber) {
        String verificationErrorCard = "4119 8627 6033 8320";
        String transactionErrorCard = "4005 5192 0000 0004";

        if (errorNumber.equals("Verification Error Card")) {
            errorNumber = verificationErrorCard;
        }
        if (errorNumber.equals("Transaction Error Card")) {
            errorNumber = transactionErrorCard;
        }

        WebElement fieldFirstName = driver.findElement(By.xpath("//*[contains(text(),'First Name')]/../input"));
        fieldFirstName.sendKeys("Nikita");
        WebElement fieldLastName = driver.findElement(By.xpath("//*[contains(text(),'Last Name')]/../input"));
        fieldLastName.sendKeys("Demin");
        WebElement fieldExpiry = driver.findElement(By.xpath("(//*[contains(text(),'Expiry')]/../div/input)[1]"));
        fieldExpiry.sendKeys("1222");
        WebElement fieldCVV = driver.findElement(By.xpath("//*[contains(text(),'CVV')]/../input"));
        fieldCVV.sendKeys("123");
        WebElement fieldCardNumber = driver.findElement(By.xpath("//*[contains(text(),'Card Number')]/../input"));
        fieldCardNumber.sendKeys(errorNumber);

        WebElement clickUpdateButton = driver.findElement(By.xpath("//*[contains(text(),'Update')]/parent::button"));
        clickUpdateButton.click();
    }


    public void clickAgree() throws Exception {
        if (!checkClickableAgreeButton()) {
            WebElement clickAgreeButton = driver.findElement(By.xpath("//input[@type='checkbox']"));
            clickAgreeButton.click();
            checkClickableAgreeButton();
        } else {
            throw new Exception("trouble with Checkout button");
        }
    }

    public boolean checkClickableAgreeButton() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 2);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'Pay $')]/parent::button")));
            element.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void checkSuccessOfPay() throws Exception {
        getErrorPayText();
        if (!getSuccessPayText()) {
            throw new Exception("trouble with payment process");
        } else {
            openSubcirption();
            List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//span[text()='[Exchange not created yet]']"));
            int quantityOfNewExchangesNew = checkNewExchanges.size();

            if (quantityOfNewExchanges != quantityOfNewExchangesNew) {
                throw new Exception();
            }
        }
    }

    public boolean getSuccessPayText() {
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Successful Subscription']")));
            WebElement clickSuccessButton = driver.findElement(By.xpath("//a[@href='/app/exchanges' and text()='Go to exchanges']"));
            clickSuccessButton.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void getErrorPayText() throws Exception {
        try {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Error message')]")));
            String findTextOfError = getElementByXpath(driver, "//*[contains(text(),'Error message')]").getText();
            String parseFindTextOfError = findTextOfError.replaceAll("[^0-9]", "").substring(4);
            if (parseFindTextOfError.equals("3009")) {
                throw new Exception("Due to \"Verification Error Card\"");
            }
            if (parseFindTextOfError.equals("3001")) {
                throw new Exception("Due to \"Transaction Error Card\"");
            }
        } catch (TimeoutException e) {
        }
    }

    public boolean getTrueExchanges() throws InterruptedException {
        List<WebElement> findAllTrueExchanges = getElementsByXpath(driver, "//input [@type='checkbox' and @value='true']");
        int iFindAllTrueExchanges = findAllTrueExchanges.size();
        if (iFindAllTrueExchanges == quantityOfNewExchanges + 1) {
            return true;
        } else {
            return false;
        }
    }

    public void checkQuantityOfExchanges() {
        try {
            waitForElementToAppear(driver, "//div[contains(text(),'You don')]", 3);
            quantityOfNewExchanges = 0;
        } catch (Exception e) {
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            List<WebElement> checkNewExchanges = driver.findElements(By.xpath("//input[@type='checkbox']"));
            quantityOfNewExchanges = checkNewExchanges.size();
            quantityOfNewExchanges--;
        }
    }

    public void openSubcirption() throws Exception {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        waitForElementToAppear(driver, "//span[text()='test']", 5);
        WebElement testButton = driver.findElement(By.xpath("//span[text()='test']"));
        testButton.click();
        WebElement subscriptionButton = driver.findElement(By.xpath("//a[text()='Subscription']"));
        subscriptionButton.click();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        waitforPageLoad(driver);
        if (getElementByXpath(driver, "//h1[text()='Subscription']") == null) {
            throw new Exception("Subscription doesn't open");
        }

        checkQuantityOfExchanges();

    }


}





