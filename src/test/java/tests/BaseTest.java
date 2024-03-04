package tests;

import com.microsoft.playwright.*;
import factory.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PomContainer;

public class BaseTest {
    Page page;
    PomContainer pom;

    @BeforeMethod
    public void setup() {
        page = PageFactory.initializePage();
        pom = new PomContainer(page);
    }

    @AfterMethod
    public void tearDown() {
        page.close();
        PageFactory.closePlaywright();
    }
}
