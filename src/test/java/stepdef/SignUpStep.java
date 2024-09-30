package stepdef;

import pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SignUpStep {
    HomePage homePage;

    public SignUpStep(){
        this.homePage = new HomePage();
    }

    @When("user click sign up menu")
    public void user_click_sign_up_menu() {
        homePage.userClicksSignUpMenu();
    }
    @Then("validate sign up pop-up menu is displayed")
    public void validateSignUpPopUpMenuIsDisplayed() {
        homePage.validateSignUpPopUpIsDisplayed();
    }
    @And("user input random email in sign up menu")
    public void userInputRandomEmailInSignUpMenu() {
        homePage.userInputEmailToSignUp();
    }
    @And("user input password in sign up menu {string}")
    public void userInputPasswordInSignUpMenu(String defaultPassword) {
        homePage.userInputPasswordToSignUp(defaultPassword);
    }
    @And("user click sign up button")
    public void userClickSignUpButton() {
        homePage.userClickSignUpButton();
    }
    @And("user input email in sign up menu {string}")
    public void userInputEmailInSignUpMenu(String existingEmail) {
        homePage.userInputExistingEmailToSignUp(existingEmail);
    }
}