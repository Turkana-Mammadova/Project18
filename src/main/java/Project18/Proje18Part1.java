package Project18;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Proje18Part1 extends Basecodes {

    @Given("I Navigate to {string}")
    public void InavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
        driver.get(url);
    }

    @Given("I enter {string} and {string} for new user")
    public void iEnterAndForNewUser(String username, String password) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.inputusername));
        driver.findElement(Selectors.inputusername).sendKeys(username);
        driver.findElement(Selectors.inputpassword).sendKeys(password);
    }

    @And("I click save button")
    public void iClickSaveButton() {
        driver.findElement(Selectors.inputsave).click();
    }


    @Then("I should get the username must longer than 4")
    public void iShouldGetTheusernamemustlongerthan4() {
        String alertuser = driver.switchTo().alert().getText();
        Assert.assertEquals(alertuser, "Username too short.  The username must be at least 4 characters in length.");
    }

    @Then("I should get the password must longer than 4")
    public void iShouldGetThepasswordmustlongerthan4() {
        String alertuser = driver.switchTo().alert().getText();
        Assert.assertEquals(alertuser, "Password too short.  The password must be at least 4 characters in length.");
    }


    @Then("Navigate to Add user menu")
    public void navigateToAddUserMenu() {
        driver.findElement(Selectors.addausername).click();
    }


    @Given("I enter username:{word} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.inputusername));
        driver.findElement(Selectors.inputusername).sendKeys(username);
        driver.findElement(Selectors.inputpassword).sendKeys(password);
    }

    @Then("I should create new account")
    public void iShouldCreateNewAccount() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.theusername),"New account didnt save");
        String result=driver.findElement(Selectors.theusername).getText();
        Assert.assertEquals(result,"Below is the current single record within the database:");

    }

    @When("I click login button")
    public void iClickLoginButton() {
        driver.findElement(Selectors.inputsave).click();
    }


    @Then("I should get success message")
    public void iShouldGetSuccessMessage() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.successlogin),"Log in menu is not visible");
        String result=driver.findElement(Selectors.successlogin).getText();
        Assert.assertEquals(result,"**Successful Login**");
    }

    
    @And("Navigate to log in page")
    public void navigateToLogInPage() {
        driver.findElement(Selectors.loginausername).click();
    }

    @Then("I should get the fail message")
    public void iShouldGetTheFailMessage() {
        waitFor(ExpectedConditions.visibilityOfElementLocated(Selectors.faillogin),"Log in menu is not visible");
        String result=driver.findElement(Selectors.faillogin).getText();
        Assert.assertEquals(result,"**Failed Login**");
    }


}