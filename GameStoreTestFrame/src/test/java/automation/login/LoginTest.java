package automation.login;

import org.testng.annotations.Test;

import automation.BaseTest;
import model.pages.login.LoginPage;
import model.pages.registration.RegistrationPage;

public class LoginTest extends BaseTest {
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.openPage().login("diana@gmail.com", "eh1as1");
    }

    @Test
    public void registerUserTest() {
        RegistrationPage registrationPage = new RegistrationPage();
        registrationPage.openPage().registerUser("Diana", "dianaa@gmail.com", "eh1as1");
    }
}
