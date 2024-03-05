package pages;

import com.microsoft.playwright.Page;

public class PomContainer {
    public HomePage homePage;
    public SearchPage searchPage;
    public HeaderPage headerPage;

    public PomContainer(Page page) {
        homePage = new HomePage(page);
        searchPage = new SearchPage(page);
        headerPage = new HeaderPage(page);
    }
}
