package pages;

import com.microsoft.playwright.Page;

public class LoginPage {
    Page page;
    private String email = "input#input-email";
    private String password = "input#input-password";
    private String loginButton = "input[value=Login]";

    public LoginPage(Page page) {
        this.page = page;
    }

    public void login(String emailInput, String passwordInput) {
        page.fill(email,emailInput);
        page.fill(password, passwordInput);
        page.click(loginButton);
    }

}
