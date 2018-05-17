package automation.product_test;

import java.io.FileNotFoundException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import model.pages.bucket.BucketPage;
import model.pages.game.MyGamesPage;
import model.pages.login.LoginPage;
import model.pages.my_orders.MyOrdersPage;
import model.pages.products.ProductsPage;

public class ProductPageTest extends BaseTest {
    @Test
    public void searchAndBuyGameWithExistedPaymentInfoTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage().login("dianaa@gmail.com", "eh1as1");

        ProductsPage productsPage = new ProductsPage();
        productsPage.waitPageLoading(500000)
                .searchProduct("FIFA 18")
                .waitPageLoading(30000)
                .buyProduct()
                .waitPageLoading(3000);

        Assert.assertTrue(productsPage.isSuccessNotificationDisplayed());

        productsPage.checkout().waitPageLoading(100000);

        Assert.assertEquals(productsPage.getPriceFromString(), "6;0");

        productsPage.confirmOrder().proceedOrder();

        MyOrdersPage myOrdersPage = new MyOrdersPage();

        Assert.assertEquals("http://games-app.azurewebsites.net/my-orders", myOrdersPage.waitPageLoading(20000).getCurrentUrl());
    }

    @Test
    public void searchAndBuyGameWithNewPaymentInfoTest() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage().login("dianaa@gmail.com", "eh1as1");

        ProductsPage productsPage = new ProductsPage();
        productsPage.waitPageLoading(500000)
                .searchProduct("FIFA 18 Prime")
                .waitPageLoading(300000)
                .buyProduct()
                .waitPageLoading(10000);

        Assert.assertTrue(productsPage.isSuccessNotificationDisplayed());

        productsPage.checkout().waitPageLoading(100000);

        Assert.assertEquals(productsPage.getPriceFromString(), "80");

        productsPage.confirmOrder()
                .addNewPayment("4532683381813502", "111", "Diana Shchetynina");

        BucketPage bucketPage = new BucketPage();
        bucketPage.waitPageLoading(300000);

        MyOrdersPage myOrdersPage = new MyOrdersPage();

        Assert.assertEquals(myOrdersPage.waitPageLoading(400000).getCurrentUrl(), "http://games-app.azurewebsites.net/my-orders");
    }

    @Test
    public void downloadGame() throws FileNotFoundException {
        WebDriverManager.chromedriver().setup();

        LoginPage loginPage = new LoginPage();
        loginPage.openPage().login("diana@gmail.com", "eh1as1");

        ProductsPage productsPage = new ProductsPage();
        productsPage
                .openToolbar()
                .openMyGamesPage()
                .waitPageLoading(10000);
        MyGamesPage myGamesPage = new MyGamesPage();
        myGamesPage.downloadGame();
    }
}
