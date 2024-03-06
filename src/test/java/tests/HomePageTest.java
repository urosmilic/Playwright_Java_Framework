package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "searchDataProvider")
    public void performSearchAndVerifySearchPageTitle(String input) {
        pom.homePage.navigateToHomePage();
        pom.searchPage = pom.homePage.runSearch(input);
        Assert.assertEquals(pom.searchPage.getSearchPageTitle(), "Search - " + input);
    }

    @DataProvider
    public String[][] searchDataProvider() {
        return new String[][]{{"Mac"}, {"iphone"}};
    }

    @Test(priority = 2, dataProvider = "currencyDataProvider")
    public void selectAndVerifyCurrency(String currency, String currencySymbol) {
        pom.homePage.navigateToHomePage();
        pom.headerPage.selectCurrency(currency);
        Assert.assertTrue(pom.headerPage.getCurrencyText().contains(currencySymbol));
    }

    @DataProvider
    public String[][] currencyDataProvider() {
        return new String[][]{{"EUR", "€"}, {"GBP", "£"}, {"USD", "$"}};
    }

}
