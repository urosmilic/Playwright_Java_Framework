package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HeaderPage {
    Page page;
    private String currencyIcon = "button:has-text('Currency')";
    private String currencyOptions = "form#form-currency li button";
    private String myAccount = "nav#top a[title='My Account']";
    private String registerLink = "ul.dropdown-menu.dropdown-menu-right li a:has-text('Register')";
    private String loginLink = "ul.dropdown-menu.dropdown-menu-right li a:has-text('Login')";


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

    public void navigateToLoginPage() {
        page.click(myAccount);
        page.click(loginLink);
    }

}
