package org.bhaane;

import com.thoughtworks.gauge.Step;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.bhaane.BaseWorkspace.*;
import static org.bhaane.BhaaneSteps.driver;
import static org.bhaane.BhaaneSteps.registrationForm;

public class BhaaneTest {
    BhaaneSteps bhaaneSteps;

    public BhaaneTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        bhaaneSteps = new BhaaneSteps(driver);
    }

    @Step("open <url> on browser.")
    public void openUrl(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Step("register to bhaane with required fields.")
    public void register() {
        registrationForm();
    }

    @Step("login to bhaane with required fields.")
    public void login() {
        loginForm();
    }

    @Step("search for product in searchbox and add to cart and check summary of product.")
    public void addToCart() {
        addToCartFunction();
    }

    @Step("login to bhaane with valid required fields.")
    public void validLogIn() {
        logOn();
    }

    @Step("close the browser.")
    public void close() {
        driver.close();
    }
}
