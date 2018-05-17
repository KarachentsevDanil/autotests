package model.pages.products;

import static com.codeborne.selenide.Selenide.$;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import model.pages.BasePage;

public class ProductsPage extends BasePage<ProductsPage> {
    private static final By TITLE_FIELD_SELECTOR = Selectors.byXpath("//input[@aria-label='Search ...']");
    private static final By DETAILS_BUTTON_SELECTOR = Selectors.byXpath("//div[contains(text(),'Details')]");
    private SelenideElement titleField = $(TITLE_FIELD_SELECTOR);

    @FindBy(xpath = "//button[@class='pull-right btn btn--small primary']")
    private SelenideElement applyButton;
    @FindBy(xpath = "//button[@class='flat-button btn primary']//div[@class='btn__content']")
    private SelenideElement buyButton;
    @FindBy(xpath = "//span[@class='badge']")
    private SelenideElement bucket;
    @FindBy(xpath = "//a[@class='btn btn--block btn--router theme--dark primary']/div")
    private SelenideElement checkoutButton;
    @FindBy(xpath = "div[@id='noty_bar_4d12e0f8-ba9e-4a99-957c-d3a9eca78b8e']")
    private SelenideElement warningNotification;
    @FindBy(xpath = "//div[@class='noty_body']")
    private SelenideElement successNotification;
    @FindBy(xpath = "//button[@class='btn theme--dark primary']/div")
    private SelenideElement confirmOrder;
    @FindBy(xpath = "//div [@class='order-details-block']//p[2]")
    private SelenideElement totalPrice;
    @FindBy(xpath = "//div[@class='payment-block']")
    private SelenideElement paymentBlock;
    @FindBy(xpath = "//button[@class='pull-right btn primary']//div[contains(text(),'Proceed')]")
    private SelenideElement proceedOrderButton;
    @FindBy(xpath = "//button[@class='btn primary']/div")
    private SelenideElement payNowButon;
    @FindBy(xpath = "//button[@class='toolbar__side-icon btn btn--icon']/div")
    private SelenideElement toolbarButton;
    @FindBy(xpath = "//div[@class='list__tile__content']//div[contains(text(),'My Games')]")
    private SelenideElement myGamesButton;
    @FindBy(xpath = "//div[contains(text(),'Details')]")
    private SelenideElement detailsButton;
    @FindBy(xpath = "//button[@class='pull-right btn primary']/div[contains(text(),'Add New Payment')]")
    private SelenideElement addNewPayment;
    @FindBy(xpath = "//input[@aria-label='Credit Card Number']")
    private SelenideElement creditCardNumberField;
    @FindBy(xpath = "//input[@aria-label='CVV Code']")
    private SelenideElement cvvCodeField;
    @FindBy(xpath = "//div[@class='input-group__input']//div[contains(text(),'March')]")
    private SelenideElement expirationMonthField;
    @FindBy(xpath = "//div[@class='input-group__input']//div[contains(text(),2018)]")
    private SelenideElement expirationYearField;
    @FindBy(xpath = "//div[@class='input-group__input']//div[contains(text(),'Ukraine')]")
    private SelenideElement countryField;
    @FindBy(xpath = "//input[@aria-label='Full Name']")
    private SelenideElement fullNameField;

    public ProductsPage() {
        super(DETAILS_BUTTON_SELECTOR, "http://games-app.azurewebsites.net/games");
    }

    public ProductsPage searchProduct(String gameName) {
        titleField.shouldBe(Condition.visible).sendKeys(gameName);
        applyButton.shouldBe(Condition.visible).click();
        return this;
    }

    public ProductsPage buyProduct() {
        buyButton.shouldBe(Condition.visible).click();
        successNotification.shouldBe(Condition.visible);
        return this;
    }

    public boolean isSuccessNotificationDisplayed() {
        return successNotification.is(Condition.visible);
    }

    public ProductsPage checkout() {
        successNotification.shouldBe(Condition.visible).click();
        bucket.shouldBe(Condition.visible).click();
        checkoutButton.shouldBe(Condition.visible).click();
        return this;
    }

    public ProductsPage confirmOrder() {
        bucket.shouldBe(Condition.visible).click();
        confirmOrder.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        return this;
    }

    public String getPriceFromString() {
        return totalPrice.text().split(StringUtils.SPACE)[2];
    }

    public ProductsPage proceedOrder() {
        paymentBlock.shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
        proceedOrderButton.shouldBe(Condition.visible).click();
        payNowButon.shouldBe(Condition.visible).click();
        return this;
    }

    public ProductsPage openToolbar() {
        toolbarButton.shouldBe(Condition.visible).click();
        return this;
    }

    public ProductsPage openMyGamesPage() {
        myGamesButton.shouldBe(Condition.visible).click();
        return this;
    }

    public ProductsPage addNewPayment(String creditCard, String cvv, String fullName) {
        addNewPayment.shouldBe(Condition.visible).click();
        creditCardNumberField.shouldBe(Condition.visible).sendKeys(creditCard);
        cvvCodeField.shouldBe(Condition.visible).sendKeys(cvv);
        expirationMonthField.shouldBe(Condition.visible).click();
        expirationYearField.shouldBe(Condition.visible).click();
        countryField.shouldBe(Condition.visible).click();
        fullNameField.shouldBe(Condition.visible).sendKeys(fullName);
        proceedOrderButton.click();
        payNowButon.shouldBe(Condition.visible).click();
        return this;
    }
}
