package pages;

import com.microsoft.playwright.Page;

public class SearchPage {
    Page page;

    String searchTitle = "div#content h1";

    public SearchPage(Page page) {
        this.page = page;
    }

    public String getSearchPageTitle() {
        return page.textContent(searchTitle);
    }

}
