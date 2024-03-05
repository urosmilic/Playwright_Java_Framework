package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderPage {
    Page page;
    private String currencyIcon = "button:has-text('Currency')";
    private String currencyOptions = "form#form-currency li button";

    public HeaderPage(Page page) {
        this.page = page;
    }

    public void selectCurrency(String currency){
        page.click(currencyIcon);
        Locator options = page.locator(currencyOptions);
        for(int i = 0; i < options.count(); i++) {
            if(options.nth(i).getAttribute("name").equals(currency)){
                options.nth(i).click();
                break;
            }
        }
    }

    public String getCurrencyText() {
        return page.textContent(currencyIcon);
    }

}
