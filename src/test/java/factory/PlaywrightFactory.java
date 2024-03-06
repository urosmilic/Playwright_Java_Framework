package factory;

import com.microsoft.playwright.*;

public class PlaywrightFactory {
    private static ThreadLocal<Playwright> threadLocalPlaywright = new ThreadLocal<>();
    private static ThreadLocal<Browser> threadLocalBrowser = new ThreadLocal<>();
    private static ThreadLocal<BrowserContext> threadLocalBrowserContext = new ThreadLocal<>();
    private static ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();

    public static void initializePlaywright() {
        threadLocalPlaywright.set(Playwright.create());
        String inputBrowser = System.getProperty("browser");
        String browserType = inputBrowser == null ? "chrome" : inputBrowser;

        switch (browserType) {
            case "chromeHeadless" -> threadLocalBrowser.set(threadLocalPlaywright.get().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(true)));
            case "chrome" -> threadLocalBrowser.set(threadLocalPlaywright.get().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false)));
            case "edgeHeadless" -> threadLocalBrowser.set(threadLocalPlaywright.get().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(true)));
            case "edge" -> threadLocalBrowser.set(threadLocalPlaywright.get().chromium()
                    .launch(new BrowserType.LaunchOptions().setChannel("msedge").setHeadless(false)));
            case "firefoxHeadless" -> threadLocalBrowser.set(threadLocalPlaywright.get().firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true)));
            case "firefox" -> threadLocalBrowser.set(threadLocalPlaywright.get().firefox()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false)));
            case "webkitHeadless" -> threadLocalBrowser.set(threadLocalPlaywright.get().webkit()
                    .launch(new BrowserType.LaunchOptions().setHeadless(true)));
            case "webkit" -> threadLocalBrowser.set(threadLocalPlaywright.get().chromium()
                    .launch(new BrowserType.LaunchOptions().setHeadless(false)));
            default -> throw new IllegalArgumentException("Wrong browser type entered!");
        }
    }

    public static Page initializePage() {
        threadLocalBrowserContext.set(threadLocalBrowser.get().newContext());
        threadLocalPage.set(threadLocalBrowserContext.get().newPage());
        return threadLocalPage.get();
    }

    public static void closePage() {
        threadLocalPage.get().close();
        threadLocalBrowserContext.get().close();
    }

    public static void closePlaywright() {
        threadLocalBrowser.get().close();
        threadLocalPlaywright.get().close();
    }

}
