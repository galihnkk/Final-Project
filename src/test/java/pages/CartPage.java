package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static helper.Utility.driver;
import static org.junit.Assert.*;

public class CartPage {

    By cartTableList = By.id("tbodyid");
    By deleteButtonLastAddedItem = By.xpath("//*[@id='tbodyid']/tr[@class='success' and td[2]/text()='Nokia lumia 1520']/td[4]/a");
    By placeOrderButton = By.xpath("//button[@class='btn btn-success']");
    By placeOrderPopUp = By.id("orderModalLabel");
    By orderNameField = By.id("name");
    By orderCountryField = By.id("country");
    By orderCityField = By.id("city");
    By orderCreditCardField = By.id("card");
    By orderMonthField = By.id("month");
    By orderYearField = By.id("year");
    By purchaseButtonInPlaceOrderPopUp = By.xpath("//button[text()='Purchase']");
    By thankYouPopUp = By.xpath("//h2[text()='Thank you for your purchase!']");
    By priceColumnInCart = By.xpath("//tbody[@id='tbodyid']/tr");
    By totalPriceDisplayed = By.id("totalp");


    public void validateItemIsInCart() throws InterruptedException {
        Thread.sleep(2000);
        String cartItemList = driver.findElement(cartTableList).getText();
        String expectedItem1 = "Nexus 6";
        assertTrue(cartItemList.contains(expectedItem1));
    }

    public void deleteItemFromCart(String item) throws InterruptedException {
        int items = Integer.parseInt(item);
        for (int i = 1; i <= items; i++) {
            driver.findElement(By.xpath("(//*[text()='Delete'])[1]")).click();
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
    }

    public void validateBothItemAreInCart() throws InterruptedException {
        Thread.sleep(2000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        List<WebElement> childElements = tbody.findElements(By.xpath("./*"));
        int jumlahChild = childElements.size();
        assertThat(jumlahChild).isEqualTo(2);
    }

    public void setDeleteButtonLastAddedItem() throws InterruptedException {
        driver.findElement(deleteButtonLastAddedItem).click();
        Thread.sleep(2000);
    }

    public void validateCartDoesNotContainLastAddedItem() throws InterruptedException {
        Thread.sleep(2000);
        WebElement tbody = driver.findElement(By.xpath("//tbody"));
        List<WebElement> childElements = tbody.findElements(By.xpath("./*"));
        int jumlahChild = childElements.size();
        assertThat(jumlahChild).isEqualTo(1);
    }

    public void validateTotalPriceInCart() {
        List<WebElement> itemRows = driver.findElements(priceColumnInCart);
        Integer totalPrice = null;
        for (WebElement row : itemRows) {
            String itemPrices = row.findElement(By.xpath("./td[3]")).getText();
            int integerItemPrice = Integer.parseInt(itemPrices);
            if (totalPrice == null) {
                totalPrice = integerItemPrice;
            } else {
                totalPrice = Integer.sum(totalPrice, integerItemPrice);
            }
        }
        String stringTotalPrice = String.valueOf(totalPrice);
        assertEquals(stringTotalPrice, driver.findElement(totalPriceDisplayed).getText());
    }

    public void clickPlaceOrderButton() {
        driver.findElement(placeOrderButton).click();
    }

    public void validatePlaceOrderPopUpIsDisplayed() {
        driver.findElement(placeOrderPopUp).isDisplayed();
    }

    public void enterNameInOrderPopUp(String orderName) {
        driver.findElement(orderNameField).sendKeys(orderName);
    }

    public void enterCountryInOrderPopUp(String orderCountry) {
        driver.findElement(orderCountryField).sendKeys(orderCountry);
    }

    public void enterCreditCardInOrderPopUp(String orderCC) {
        driver.findElement(orderCreditCardField).sendKeys(orderCC);
    }

    public void enterCityInOrderPopUp(String orderCity) {
        driver.findElement(orderCityField).sendKeys(orderCity);
    }

    public void enterMonthInOrderPopUp(String orderMonth) {
        driver.findElement(orderMonthField).sendKeys(orderMonth);
    }

    public void enterYearInOrderPopUp(String orderYear) {
        driver.findElement(orderYearField).sendKeys(orderYear);
    }

    public void clickPurchaseButton() {
        driver.findElement(purchaseButtonInPlaceOrderPopUp).click();
    }

    public void validateThankYouPopUp() throws InterruptedException {
        Thread.sleep(200);
        String findThankYouPopUp = driver.findElement(thankYouPopUp).getText();
        assertTrue(findThankYouPopUp.contains("Thank you for your purchase!"));
    }
}