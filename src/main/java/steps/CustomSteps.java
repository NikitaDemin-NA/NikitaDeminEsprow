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
    public void getPage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver92_M1");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors","--disable-extensions","--no-sandbox","--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.get("https://spa-dev.etpmarkets.com:3000/");
    }

    @Given("check page title")
    public void getTitle() throws Exception {
        waitforPageLoad(driver);
        try {
            WebElement title = driver.findElement(By.xpath("//title"));
            System.out.println(title.getText());
            if(title.getText().contains("ETP Markets")){
            }
        } catch (Exception e){
            throw new Exception("Main page doesn't open");
        }
    }

    public void waitforPageLoad(WebDriver driver){
        new WebDriverWait(driver,30).until(wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @Given("sign in with login = {string} and password = {string}")
    public void logIn(String emailField, String passwordField) throws Exception {
        clickSignIn();
        checkAuthorizationPage();
        setEmail(emailField);
        setPassword(passwordField);
        authorizationButton();
    }


    public void checkAuthorizationPage() throws Exception {
        waitforPageLoad(driver);
        if(getElementByXpath(driver, "//h2[text()='Log in to ETP Markets']")== null){
        throw new Exception("Log In page doesn't open");
        }
    }

    public void clickSignIn(){
        WebElement SignIn = driver.findElement(By.xpath("//a[@href='/auth/sign-in']"));
        SignIn.click();
    }

    public void setEmail(String emailField){
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.clear();
        email.sendKeys(emailField);
    }

    public void setPassword(String passwordField){
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.clear();
        password.sendKeys(passwordField);
    }

    public void authorizationButton(){
        WebElement signin = driver.findElement(By.xpath("//button[text()='Sign In']"));
        signin.click();
    }




    @Given("close browser")
    public void tearDown() {
            driver.quit();
    }

}
