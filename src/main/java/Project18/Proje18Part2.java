package Project18;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Proje18Part2 extends Basecodes {

    @Given("Navigate to {string}")
    public void navigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        wait=new WebDriverWait(driver,5);
        driver.get(url);
    }


    @Given("I enter {string} and {string}")
    public void iEnterAnd(String username, String password) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.username));
        driver.findElement(Selectors.username).sendKeys(username);
        driver.findElement(Selectors.password).sendKeys(password);
    }

    @When("Click to the login button")
    public void clickToTheLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(Selectors.loginbutton));
        driver.findElement(Selectors.loginbutton).click();
    }


    @Then("I should get failure message")
    public void iShouldGetFailureMessage() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.loginalert,"Invalid username or password"));
        String actual=driver.findElement(Selectors.loginalert).getText();
        Assert.assertEquals(actual,"Invalid username or password");
    }


    @Given("I login using username {word} and password {string}")
    public void iLoginUsingUsernameDauletGmailComAndPassword(String username, String password)  {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.username));
        driver.findElement(Selectors.username).clear();
        driver.findElement(Selectors.username).sendKeys(username);
        driver.findElement(Selectors.password).clear();
        driver.findElement(Selectors.password).sendKeys(password);
    }

    @Then("I sould login")
    public void iSouldLogin() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.accountname,"D. Saurbekov"));
        String actual=driver.findElement(Selectors.accountname).getText();
        Assert.assertEquals(actual,"D. Saurbekov");
    }


    @Then("I should get Password required")
    public void iShouldGetPasswordrequired() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.passwordalert,"Password is required"));
        String actual=driver.findElement(Selectors.passwordalert).getText();
        Assert.assertEquals(actual,"Password is required");}

    @Then("I should get Email required")
    public void iShouldGetEmailrequired() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.emailalert,"Email is required"));
        String actual=driver.findElement(Selectors.emailalert).getText();
        Assert.assertEquals(actual,"Email is required");}

    @Then("I should get Password and Email required")
    public void iShouldGetPasswordandEmailrequired() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(Selectors.passwordalert,"Password is required"));
        String actual1=driver.findElement(Selectors.passwordalert).getText();
        Assert.assertEquals(actual1,"Password is required");
        String actual2=driver.findElement(Selectors.emailalert).getText();
        Assert.assertEquals(actual2,"Email is required");}

    @After
    public void tearDown() {
        driver.quit();
    }

}

