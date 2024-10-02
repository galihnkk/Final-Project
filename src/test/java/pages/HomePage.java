package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;

import static helper.Utility.driver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePage {
    static Faker faker = new Faker();
    String randomName = faker.name().firstName();
    String randomEmail = randomName + "galihnkk";

    By loginMenu = By.id("login2");
    By signUpMenu = By.id("signin2");
    By loginPopUpMenu = By.id("logInModal");
    By signUpPopUpMenu = By.id("signInModal");
    By loginUserEmail = By.id("loginusername");
    By signUpUserEmail = By.id("sign-username");
    By loginUserPassword = By.id("loginpassword");
    By signUpUserPassword = By.id("sign-password");
    By loginButtoninPopUp = By.xpath("//button[text()='Log in']");
    By signUpButtoninPopUp = By.xpath("//button[text()='Sign up']");
    By welcomeUserInHomepage = By.id("nameofuser");
    By firstProduct = By.xpath("//a[text()='Nexus 6']");
    By itemAddToCartButton = By.xpath("//a[contains(@class, 'btn-success')]");
    By homepageCartMenu = By.id("cartur");
    By secondProduct = By.xpath("//a[text()='Samsung galaxy s7']");
    By homePageMenu = By.xpath("//a[text()='Home ']");


    public void userGoToHomePage(){
        driver.get("https://www.demoblaze.com/index.html");
    }
    public void userClickLoginMenu(){
        driver.findElement(loginMenu).click();
    }
    public void userClicksSignUpMenu(){
        driver.findElement(signUpMenu).click();
    }
    public void validateLoginPopUpIsDisplayed(){
        driver.findElement(loginPopUpMenu).isDisplayed();
    }
    public void validateSignUpPopUpIsDisplayed(){
        driver.findElement(signUpPopUpMenu).isDisplayed();
    }
    public void userInputEmailToLogin(String userEmail){
        driver.findElement(loginUserEmail).sendKeys(userEmail);
    }
    public void userInputEmailToSignUp(){
        driver.findElement(signUpUserEmail).sendKeys(randomEmail);
    }
    public void userInputExistingEmailToSignUp(String existingEmail){
        driver.findElement(signUpUserEmail).sendKeys(existingEmail);
    }
    public void userInputPasswordToLogin(String userPassword){
        driver.findElement(loginUserPassword).sendKeys(userPassword);
    }
    public void userInputPasswordToSignUp(String defaultPassword){
        driver.findElement(signUpUserPassword).sendKeys(defaultPassword);
    }
    public void userClickLoginButton() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(loginButtoninPopUp).click();
    }
    public void userClickSignUpButton(){
        driver.findElement(signUpButtoninPopUp).click();
    }
    public void usernameIsDisplayedinHomepage() throws InterruptedException {
        Thread.sleep(2000);
        assertEquals("Welcome "+"galihnkk",driver.findElement(welcomeUserInHomepage).getText());
    }
    public void homepagePopUpMessage(String homepagePopUpMessage) throws InterruptedException {
        Thread.sleep(2000);
        assertEquals(homepagePopUpMessage,driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
    }
    public void phoneProduct() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(firstProduct).click();
    }

    public void phoneProduct2() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(secondProduct).click();
    }

    public void addItemToCart(){
        driver.findElement(itemAddToCartButton).click();
    }
    public void clickCartMenu() throws InterruptedException {
        driver.findElement(homepageCartMenu).click();
        Thread.sleep(1000);
    }
    public void goToHomePageMenu() {
        driver.findElement(homePageMenu).click();
    }
}