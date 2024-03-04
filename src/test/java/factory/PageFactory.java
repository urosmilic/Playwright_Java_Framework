package factory;

import com.microsoft.playwright.*;

public class PageFactory {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext browserContext;
    private static Page page;

    public static Page initializePage() {
        playwright = Playwright.create();
        String inputBrowser = System.getProperty("browser");
        String browserType = inputBrowser == null ? "chrome" : inputBrowser;

        switch (browserType) {
            case "chromeHeadless" -> browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true));
            case "chrome" -> browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
            case "edgeHeadless" -> browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true));
            case "edge" -> browser = playwright.chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false));
            case "firefoxHeadless" -> browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));
            case "firefox" -> browser = playwright.firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "webkitHeadless" -> browser = playwright.webkit()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true));
            case "webkit" -> browser = playwright.webkit()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false));
            default -> throw new IllegalArgumentException("Wrong browser type entered!");
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        return page;
    }

    public static void closePlaywright() {
        browserContext.close();
        browser.close();
        playwright.close();
    }

}
