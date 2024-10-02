package stepdef;

import pages.CartPage;
import pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaceOrderStep {
    HomePage homePage;
    CartPage cartPage;

    public PlaceOrderStep(){
        this.homePage = new HomePage();
        this.cartPage = new CartPage();
    }

    @Given("validate total item price")
    public void validate_total_item_price() {
        cartPage.validateTotalPriceInCart();
    }

    @When("user click place order button")
    public void userClickPlaceOrderButton() {
        cartPage.clickPlaceOrderButton();
    }

    @Then("validate place order pop up is displayed")
    public void validatePlaceOrderPopUpIsDisplayed() {
        cartPage.validatePlaceOrderPopUpIsDisplayed();
    }

    @When("user enter name {string} in place order pop up menu")
    public void userEnterNameInPlaceOrderPopUpMenu(String orderName) {
        cartPage.enterNameInOrderPopUp(orderName);
    }

    @And("user enter country {string} in place order pop up menu")
    public void userEnterCountryInPlaceOrderPopUpMenu(String orderCountry) {
        cartPage.enterCountryInOrderPopUp(orderCountry);
    }

    @And("user enter city {string} in place order pop up menu")
    public void userEnterCityInPlaceOrderPopUpMenu(String orderCity) {
        cartPage.enterCityInOrderPopUp(orderCity);
    }

    @And("user enter credit card {string} in place order pop up menu")
    public void userEnterCreditCardInPlaceOrderPopUpMenu(String orderCC) {
        cartPage.enterCreditCardInOrderPopUp(orderCC);
    }

    @And("user enter month {string} in place order pop up menu")
    public void userEnterMonthInPlaceOrderPopUpMenu(String orderMonth) {
        cartPage.enterMonthInOrderPopUp(orderMonth);
    }

    @And("user enter year {string} in place order pop up menu")
    public void userEnterYearInPlaceOrderPopUpMenu(String orderYear) {
        cartPage.enterYearInOrderPopUp(orderYear);
    }

    @And("user click purchase button in place order pop up menu")
    public void userClickPurchaseButtonInPlaceOrderPopUpMenu() {
        cartPage.clickPurchaseButton();
    }

    @Then("validate thank you pop up is displayed")
    public void validateThankYouPopUpIsDisplayed() throws InterruptedException {
        cartPage.validateThankYouPopUp();
    }
}