package tests;

import factory.PlaywrightFactory;
import org.testng.annotations.*;
import pages.PomContainer;

public class BaseTest {
    static ThreadLocal<PomContainer> threadLocalPomContainer = new ThreadLocal<>();

    public static PomContainer container() {
        return threadLocalPomContainer.get();
    }

    @BeforeMethod
    public void setup() {
        PlaywrightFactory.initializePlaywright();
        threadLocalPomContainer.set(new PomContainer(PlaywrightFactory.initializePage()));
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightFactory.closePage();
        PlaywrightFactory.closePlaywright();
    }

}
