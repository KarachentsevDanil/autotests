package model.pages.game;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.SelenideElement;

import model.pages.BasePage;

public class MyGamesPage extends BasePage<MyGamesPage> {
    private static final By DOWNLOAD_BUTTON_SELECTOR = Selectors.byXpath("//div[contains(text(),'Download')]");

    @FindBy(xpath = "//div[contains(text(),'Download')]")
    private SelenideElement downloadButton;

    public MyGamesPage() {
        super(DOWNLOAD_BUTTON_SELECTOR, "http://games-app.azurewebsites.net/my-games");
    }

    public MyGamesPage downloadGame() throws FileNotFoundException {
        downloadButton.shouldBe(Condition.visible).click();
        return this;
    }
}
