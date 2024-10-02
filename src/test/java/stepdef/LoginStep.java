package stepdef;

import pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {
    HomePage homePage;

    public LoginStep(){
        this.homePage = new HomePage();
    }

    @Given("user is in homepage")
    public void user_is_in_homepage() {
        homePage.userGoToHomePage();
    }

    @When("user click login menu")
    public void userClickLoginMenu() {
        homePage.userClickLoginMenu();
    }

    @Then("validate login pop-up menu is displayed")
    public void validateLoginPopUpMenuIsDisplayed() {
        homePage.validateLoginPopUpIsDisplayed();
    }

    @And("user input email in login menu {string}")
    public void userInputEmailInLoginMenu(String userEmail) {
        homePage.userInputEmailToLogin(userEmail);
    }

    @And("user input password in login menu {string}")
    public void userInputPasswordInLoginMenu(String userPassword) {
        homePage.userInputPasswordToLogin(userPassword);
    }

    @And("user click login button")
    public void userClickLoginButton() throws InterruptedException {
        homePage.userClickLoginButton();
    }

    @Then("user will stayed in homepage with username displayed in menu")
    public void userWillStayedInHomepageWithUsernameDisplayedInMenu() throws InterruptedException {
        homePage.usernameIsDisplayedinHomepage();
    }

    @Then("validate pop up menu displayed {string}")
    public void validatePopUpMenuDisplayed(String homepagePopUpMessage) throws InterruptedException {
        Thread.sleep(2000);
        homePage.homepagePopUpMessage(homepagePopUpMessage);
    }
}