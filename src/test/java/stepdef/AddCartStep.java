package stepdef;

import pages.CartPage;
import pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddCartStep {
    HomePage homePage;
    CartPage cartPage;

    public AddCartStep(){
        this.homePage = new HomePage();
        this.cartPage = new CartPage();
    }
    @When("user click first item in homepage")
    public void userClickFirstItemInHomepage() throws InterruptedException {
        homePage.phoneProduct();
    }

    @When("user click second item in homepage")
    public void userClickSecondItemInHomepage() {
        homePage.addMonitorItemToCart();
    }

    @And("user click add to cart button")
    public void userClickAddToCartButton() {
        homePage.addItemToCart();
    }

    @When("user click cart menu")
    public void userClickCartMenu() throws InterruptedException {
        homePage.clickCartMenu();
    }

    @Then("validate item is added in cart menu")
    public void validateItemIsAddedInCartMenu() throws InterruptedException {
        cartPage.validateItemIsInCart();
    }

    @Then("clear item from cart {string}")
    public void clearItemFromCart(String item) throws InterruptedException {
        cartPage.deleteItemFromCart(item);
    }

    @When("user delete an item from cart")
    public void userDeleteAnItemFromCart() {

    }

    @Then("item will disappeared from cart item list")
    public void itemWillDisappearedFromCartItemList() {
    }

    @When("user delete one item from cart")
    public void userDeleteItemFromCart() throws InterruptedException {
        cartPage.setDeleteButtonLastAddedItem();
    }

    @Then("deleted item will disappeared from cart item list")
    public void deletedItemWillDisappearedFromCartItemList() throws InterruptedException {
        cartPage.validateCartDoesNotContainLastAddedItem();
    }

    @Then("validate both items were added in cart menu")
    public void validateBothItemsWereAddedInCartMenu() throws InterruptedException {
        cartPage.validateBothItemAreInCart();
    }

    @And("user go back to homepage")
    public void userGoBackToHomepage() {
        homePage.goToHomePageMenu();
    }
}