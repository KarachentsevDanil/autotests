package model.pages.bucket;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import model.pages.BasePage;

public class BucketPage extends BasePage<BucketPage> {
    private static final By GO_TO_GAMES_BUTTON = Selectors.byXpath("//p[contains(text(),'Bucket')]");
    @FindBy(xpath = "//a[@class='btn btn--router']")
    private SelenideElement bucketEptyMessage;

    public BucketPage() {
        super(GO_TO_GAMES_BUTTON, "http://games-app.azurewebsites.net/bucket");
    }
}
