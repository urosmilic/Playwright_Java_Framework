package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test(priority = 1, dataProvider = "searchDataProvider")
    public void performSearchAndVerifySearchPageTitle(String input) {
        container().homePage.navigateToHomePage();
        container().searchPage = container().homePage.runSearch(input);
        Assert.assertEquals(container().searchPage.getSearchPageTitle(), "Search - " + input);
    }

    @DataProvider
    public String[][] searchDataProvider() {
        return new String[][]{{"Mac"}, {"iphone"}};
    }

    @Test(priority = 2, dataProvider = "currencyDataProvider")
    public void selectAndVerifyCurrency(String currency, String currencySymbol) {
        container().homePage.navigateToHomePage();
        container().headerPage.selectCurrency(currency);
        Assert.assertTrue(container().headerPage.getCurrencyText().contains(currencySymbol));
    }

    @DataProvider
    public String[][] currencyDataProvider() {
        return new String[][]{{"EUR", "€"}, {"GBP", "£"}, {"USD", "$"}};
    }

}
