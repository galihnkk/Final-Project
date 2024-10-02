package pages;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static helper.Utility.driver;
import static org.junit.Assert.*;

public class CartPage {

    By cartTableList = By.id("tbodyid");
    By deleteButtonLastAddedItem = By.xpath("//*[@id='tbodyid']/tr[@class='success' and td[2]/text()='Nexus 6']/td[4]/a");
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

    public void addItemToCart(String itemName) {
        By addToCartButton = By.xpath("//button[contains(text(), 'Add to cart') and @data-item='" + itemName + "']");
        driver.findElement(addToCartButton).click();

        // Optional: Wait for the cart to update
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartConfirmationMessage"))); // Adjust as needed
    }

    public void userClickSecondItemInHomepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> items = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(text(), 'Samsung galaxy s7')]")));

        System.out.println("Number of items found: " + items.size()); // Debugging output

        if (!items.isEmpty()) {
            items.get(0).click(); // Click the first matching item
        } else {
            System.out.println("Item not found.");
        }
    }


    public void validateItemIsInCart() {
        // Tunggu sampai item muncul di keranjang
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']//tr")));

        // Ambil semua item di keranjang
        List<WebElement> itemsInCart = driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr"));

        // Pastikan ada setidaknya satu item
        Assert.assertTrue("The cart should have at least one item.", itemsInCart.size() > 0);
    }


    public void deleteItemFromCart(String item) throws InterruptedException {
        int items = Integer.parseInt(item);
        for (int i = 1; i <= items; i++) {
            driver.findElement(By.xpath("(//*[text()='Delete'])[1]")).click();
            Thread.sleep(2000);
        }
        Thread.sleep(2000);
    }

    public void validateBothItemAreInCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tbody[@id='tbodyid']//tr")));

        List<WebElement> itemsInCart = driver.findElements(By.xpath("//tbody[@id='tbodyid']//tr"));

        Assert.assertTrue("The cart should have at least one item.", itemsInCart.size() > 0);

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

    public void validateThankYouPopUp() {
        // Handle any unexpected alerts before proceeding
        handleAlertIfPresent();

        // Wait for the thank you message to be displayed
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(thankYouPopUp));

        // Retrieve the thank you message text
        String findThankYouPopUp = driver.findElement(thankYouPopUp).getText();

        // Validate that the thank you message is displayed correctly
        assertTrue("The thank you message was not displayed.", findThankYouPopUp.contains("Thank you for your purchase!"));
    }

    private void handleAlertIfPresent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept(); // Accept the alert to close it
        } catch (NoAlertPresentException e) {
            // No alert was present, so we can ignore this
        } catch (TimeoutException e) {
            // Alert was not present within the timeout, continue
        }
    }
}