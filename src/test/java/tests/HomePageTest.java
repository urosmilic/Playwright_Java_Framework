package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void checkSearchPageTitle() {
        pom.homePage.navigateToHomePage();
        String input = "Mac";
        pom.searchPage = pom.homePage.runSearch(input);
        Assert.assertEquals(pom.searchPage.getSearchPageTitle(), "Search - " + input);
    }
}
