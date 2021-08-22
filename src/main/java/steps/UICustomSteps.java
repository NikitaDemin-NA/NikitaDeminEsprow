package steps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UICustomSteps {
    WebDriver driver;
    String emailField;

    public void getPageInWindows() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_Windows.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void getPageInMac() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_Mac");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void getPageInMacM1() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_M1");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200", "--ignore-certificate-errors", "--disable-extensions", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }


    public void waitforPageLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until(wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }


    public WebElement getElementByXpath(WebDriver driver, String xpath) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            try {
                return driver.findElement(By.xpath(xpath));
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


    public void authorizationButton() throws Exception {
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign In']"));
        signin.click();

        waitforPageLoad(driver);
        if (getElementByXpath(driver, "//h1[text()='Exchange Instances']") == null) {
            throw new Exception("Exchange Instances doesn't open");
        }

        try {
            String login = getElementByXpath(driver,"//span/img[@alt='user image']//following-sibling::div").getText();
            String loginName = getElementByXpath(driver,"//p[text()='"+this.emailField+"']/parent::div/p[1]").getText();
            if (login.equals(loginName)){
            }
        } catch (Exception e){
            throw new Exception("Log In is not correct");
        }

    }


}
