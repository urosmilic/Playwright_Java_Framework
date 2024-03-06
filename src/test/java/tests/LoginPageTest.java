package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class LoginPageTest extends BaseTest {

    @Test(priority = 3, dataProvider = "loginDataProvider")
    public void successfulLogin(HashMap<String, String> loginMap) {
        container().homePage.navigateToHomePage();
        container().headerPage.navigateToLoginPage();
        container().loginPage.login(loginMap.get("email"), loginMap.get("password"));
    }

    @DataProvider
    public Object[][] loginDataProvider() {
        HashMap<String, String> loginMapA = new HashMap<>();
        loginMapA.put("email", "uros.test@gmail.com");
        loginMapA.put("password", "TestPassword123!");

        HashMap<String, String> loginMapB = new HashMap<>();
        loginMapB.put("email", "milos.test@gmail.com");
        loginMapB.put("password", "TestPassword456!");

        return new Object[][]{{loginMapA}, {loginMapB}};
    }
}