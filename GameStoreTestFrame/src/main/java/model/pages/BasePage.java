package model.pages;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;

public class BasePage<PAGE extends BasePage<PAGE>> {
    private String pageURL;
    private SelenideElement pageLoadingElement;

    protected BasePage(By pageLoadingLocator) {
        pageLoadingElement = $(pageLoadingLocator);
        Selenide.page(this);
    }

    public BasePage(By pageLoadingLocator, String pageURL) {
        this(pageLoadingLocator);
        this.pageURL = pageURL;
    }

    public PAGE openPage() {
        if (StringUtils.isNotEmpty(pageURL)) {
            Selenide.open(pageURL);
        } else {
            throw new UnsupportedOperationException("Page URL not establish");
        }

        return (PAGE) this;
    }

    public PAGE openPage(String pageUrl) {
        Selenide.open(pageUrl);
        return (PAGE) this;
    }

    public PAGE waitPageLoading(long time) {
        pageLoadingElement.waitUntil(visible, time);
        return (PAGE) this;
    }

    public String getCurrentUrl() {
        return WebDriverRunner.url();
    }
}
