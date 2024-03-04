package pages;

import com.microsoft.playwright.Page;

public class HomePage {

    Page page;
    String searchField = "input[name=search]";
    String searchIcon = "div[id=search] span";

    public HomePage(Page page) {
        this.page = page;
    }

    public void navigateToHomePage() {
        page.navigate("https://naveenautomationlabs.com/opencart/");
    }

    public SearchPage runSearch(String input) {
        page.fill(searchField, input);
        page.click(searchIcon);
        return new SearchPage(page);
    }


}
