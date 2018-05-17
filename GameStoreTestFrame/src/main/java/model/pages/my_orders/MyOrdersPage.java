package model.pages.my_orders;

import org.openqa.selenium.By;

import com.codeborne.selenide.Selectors;

import model.pages.BasePage;

public class MyOrdersPage extends BasePage<MyOrdersPage> {

    private static final By ORDERS_SELECTOR = Selectors.byXpath("//div[@class='orders-info']");

    public MyOrdersPage() {
        super(ORDERS_SELECTOR, "http://games-app.azurewebsites.net/my-orders");
    }
}
