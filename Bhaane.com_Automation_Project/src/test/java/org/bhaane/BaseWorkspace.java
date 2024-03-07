package org.bhaane;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.bhaane.BhaaneSteps.*;
import static org.bhaane.Methods.*;

public class BaseWorkspace extends ConfigReader{
    public static final long MEDIUM_TIMEOUT = 180000;
    static  String[] FIRST_NAMES = {"Adinath", "Shubham", "Bunty", "Ashish", "Ganesh", "Sarthak", "Sarang", "Nikhil", "Sahil", "Mandar"};
    static  String[] LAST_NAMES = {"Jadhav", "Nagare", "Hingmire", "Kale", "Vitnor", "Pawar", "Patil", "Kolekar", "Kadam", "Bhosale"};
    static String randomEmail = generateRandomEmail();
    static String randomPassword = generateRandomPassword();
    static String mobileNumber = generateRandomMobileNumber();
    static WebDriver driver;

    public BaseWorkspace(WebDriver driver) {
        BaseWorkspace.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static void visibleElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(MEDIUM_TIMEOUT));
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException ex) {
        }
    }

    public static void clickWebElement(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(MEDIUM_TIMEOUT));
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
        } catch (StaleElementReferenceException | ElementClickInterceptedException | TimeoutException ex) {
            webElement.click();
        }
    }

    public static void registrationForm() {
        clickWebElement(closeButton);
        clickWebElement(accountButton);
        clickWebElement(signUpButton);
        firstName.sendKeys(generateRandomFirstName());
        lastName.sendKeys(generateRandomLastName());
        email.sendKeys(generateRandomEmail());
        mobileNo.sendKeys(generateRandomMobileNumber());
        password.sendKeys(generateRandomPassword());
        submitButton.click();

        visibleElement(headerSectionLogo);
        if (headerSectionLogo.isDisplayed()){
            logger.info("Registration SuccessFul !");
        }else {
            logger.warning("Registration failed !");
        }
    }

    public static void logOn(){
        String email = ConfigReader.getUserProperty("test.user");
        String password = ConfigReader.getUserProperty("test.password");

        clickWebElement(closeButton);
        clickWebElement(accountButton);
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        submitButtonLogin.click();

        visibleElement(headerSectionLogo);
        if (headerSectionLogo.isDisplayed()){
            logger.info("LogIn SuccessFul !");
        }else {
            logger.warning("Login failed !");
        }
    }

    public static void loginForm(){
        logOn();

        visibleElement(headerSectionLogo);
        if (headerSectionLogo.isDisplayed()){
            logger.info("LogIn SuccessFul !");
        } else {
            logger.warning("Login failed !");
        }
    }

    public static void addToCartFunction(){
        String product = ConfigReader.getShopProperty("test.shop");

        visibleElement(searchBox);
        clickWebElement(searchBox);
        clickWebElement(searchField);
        searchField.sendKeys(product,Keys.ENTER);

        firstProduct.click();
        clickWebElement(addToBag);
        clickWebElement(goToCart);

        visibleElement(productInCart);
        if (productInCart.isDisplayed()){
            logger.info("Product added to cart Successfully !");
            clickWebElement(checkOut);
            visibleElement(summaryInfo);
        }else {
            logger.warning("Product Not added in cart.");
        }
    }
}
