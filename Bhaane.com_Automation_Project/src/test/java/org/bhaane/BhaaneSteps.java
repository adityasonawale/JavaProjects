package org.bhaane;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BhaaneSteps extends BaseWorkspace{
    public BhaaneSteps(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//div[@class='cross_sign md']")
    static WebElement closeButton;
    @FindBy(xpath = "//li[@class='col hidden-xs']")
    static WebElement accountButton;
    @FindBy(xpath = "//div[@data-modal='#modal-register']")
    static WebElement signUpButton;
    @FindBy(xpath = "//input[@name='first_name']")
    static WebElement firstName;
    @FindBy(xpath = "//input[@name='last_name']")
    static WebElement lastName;
    @FindBy(xpath = "(//input[@name='email'])[3]")
    static WebElement email;
    @FindBy(xpath = "//input[@name='mobile']")
    static WebElement mobileNo;
    @FindBy(xpath = "//div[@class='form-group']//input[@name='password']")
    static WebElement password;
    @FindBy(xpath = "//button[@class='btn btn-primary c-center']")
    static WebElement submitButton;
    @FindBy(xpath = "//img[@alt='bhaane']")
    static WebElement headerSectionLogo;
    @FindBy(xpath = "(//input[@name='email'])[1]")
    static WebElement loginEmail;
    @FindBy(xpath = "(//input[@name='password'])[1]")
    static WebElement loginPassword;
    @FindBy(xpath = "//button[@class='btn btn-primary'][normalize-space()='submit']")
    static WebElement submitButtonLogin;
    @FindBy(xpath = "//img[@class='ico trigger-search']")
    static WebElement searchBox;
    @FindBy(xpath = "//input[@placeholder='search']")
    static WebElement searchField;
    @FindBy(xpath = "(//img[@class='img-normal lazy loaded'])[1]")
    static WebElement firstProduct;

    @FindBy(xpath = "//span[@class='bold add-to-bag'][normalize-space()='add to bag']")
    static WebElement addToBag;
    @FindBy(xpath = "//a[normalize-space()='go to cart']")
    static WebElement goToCart;
    @FindBy(xpath = "//div[@class='img-box']//a")
    static WebElement productInCart;
    @FindBy(xpath = "//button[normalize-space()='checkout']")
    static WebElement checkOut;
    @FindBy(xpath = "//div[@class='p-lg bd dark']")
    static WebElement summaryInfo;
}
