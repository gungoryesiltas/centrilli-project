package com.centrilli.step_definitions;

import com.centrilli.pages.LoginPage;
import com.centrilli.utilities.ConfigurationReader;
import com.centrilli.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();

    @When("User goes to centrilli login page")
    public void user_goes_to_centrilli_login_page() {
        Driver.callDriver().get("https://qa.centrilli.com");
    }

    @When("User enters username {string}")
    public void user_enters_username(String string) {
        loginPage.usernameInput.sendKeys(string);
    }

    @When("User enters password {string}")
    public void user_enters_password(String string) {
        loginPage.passwordInput.sendKeys(string);
    }

    @When("User clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should see the home page of app")
    public void user_should_see_the_home_page_of_app() {

        Assert.assertTrue(loginPage.salesUserPage.isDisplayed());
    }


    @And("User enters username {string} and {string} and pushes the enter button")
    public void userEntersUsernameAndAndPushesTheEnterButton(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password + Keys.ENTER);
    }

    @When("User enters invalid  {string} and valid {string} and pushes the enter button")
    public void user_enters_invalid_username_and_valid_and_pushes_the_enter_button(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("Verify that error message")
    public void verify_that_error_message() {
        Assert.assertTrue(loginPage.alert.isDisplayed());
    }

    @And("User enters valid  {string} and invalid {string} and pushes the enter button")
    public void userEntersValidAndInvalidAndPushesTheEnterButton(String username, String password) {
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password + Keys.ENTER);
    }

    @Then("User verifies that I got message if I leave empty username.")
    public void userVerifiesThatIGotMessageIfILeaveEmptyAnyOfCredentials() {
        String message = loginPage.usernameInput.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.", message);
    }

    @Then("User verifies that I got message if I leave empty password.")
    public void userVerifiesThatIGotMessageIfILeaveEmptyPassword() {
        String message = loginPage.passwordInput.getAttribute("validationMessage");
        Assert.assertEquals("Please fill out this field.", message);
    }

    @And("User clicks on reset button")
    public void userClicksOnResetButton() {
        loginPage.resetButton.click();


    }
    @Then("User should be able to see e-mail confirmation page")
    public void user_should_be_able_to_see_e_mail_confirmation_page() {
        Assert.assertEquals("Reset password | Best solution for startups", Driver.callDriver().getTitle());
    }
}
