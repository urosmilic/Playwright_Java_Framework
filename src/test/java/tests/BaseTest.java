package tests;

import com.microsoft.playwright.*;
import factory.PlaywrightFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.PomContainer;

public class BaseTest {
    Page page;
    PomContainer pom;

    @BeforeTest
    public void setupPlaywright() {
        PlaywrightFactory.initializePlaywright();
    }

    @BeforeMethod
    public void setup() {
        page = PlaywrightFactory.initializePage();
        pom = new PomContainer(page);
    }

    @AfterMethod
    public void tearDown() {
        PlaywrightFactory.closePage();
    }

    @AfterTest
    public void tearDownPlaywright() {
        PlaywrightFactory.closePlaywright();
    }
}
