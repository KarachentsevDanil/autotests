package model.pages.registration;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import model.pages.BasePage;

public class RegistrationPage extends BasePage<RegistrationPage> {
    private static final By REGISTR_BUTTON_LOCATOR = Selectors.byXpath("//button[@class='form-button btn info']");
    private final SelenideElement registrationButton = $(REGISTR_BUTTON_LOCATOR);

    @FindBy(xpath = "//input[@aria-label='Full Name']")
    private SelenideElement fullNameField;
    @FindBy(xpath = "//input[@aria-label='E-mail']")
    private SelenideElement emailField;
    @FindBy(xpath = "//input[@aria-label='Password']")
    private SelenideElement passwordField;
    @FindBy(xpath = "//input[@aria-label='Picker in menu']")
    private SelenideElement datePicker;
    @FindBy(xpath = "//button[@type='button']//div[contains(text(),23)]")
    private SelenideElement dateFromCalendar;
    @FindBy(xpath = "//div[contains(text(),'OK')]")
    private SelenideElement okButtonOnCalendar;

    public RegistrationPage() {
        super(REGISTR_BUTTON_LOCATOR, "http://games-app.azurewebsites.net/registr");
    }

    public RegistrationPage registerUser(String name, String email, String password) {
        emailField.shouldBe(visible).sendKeys(email);
        passwordField.shouldBe(visible).sendKeys(password);
        datePicker.shouldBe(visible).click();
        dateFromCalendar.shouldBe(visible).click();
        okButtonOnCalendar.shouldBe(visible).click();
        fullNameField.shouldBe(visible).click();
        fullNameField.sendKeys(name);

        registrationButton.shouldBe(enabled).click();

        return this;
    }
}
