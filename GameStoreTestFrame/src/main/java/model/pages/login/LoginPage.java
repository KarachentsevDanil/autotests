package model.pages.login;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import model.pages.BasePage;

public class LoginPage extends BasePage<LoginPage> {
    private static final By LOGIN_BUTTON_SELECTOR = Selectors.byCssSelector(".btn__content");
    private final SelenideElement loginButton = $(LOGIN_BUTTON_SELECTOR);

    @FindBy(xpath = "//input[@aria-label='E-mail']")
    private SelenideElement emailField;
    @FindBy(xpath = "//input[@aria-label='Password']")
    private SelenideElement passwordField;

    public LoginPage() {
        super(LOGIN_BUTTON_SELECTOR, "http://games-app.azurewebsites.net/");
    }

    public LoginPage login(String email, String password) {
        emailField.shouldBe(visible).sendKeys(email);
        passwordField.shouldBe(visible).sendKeys(password);
        loginButton.shouldBe(enabled).click();

        return this;
    }
}
