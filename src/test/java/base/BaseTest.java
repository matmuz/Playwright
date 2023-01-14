package base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import lombok.extern.java.Log;
import org.example.browser.BrowserFactory;
import org.example.config.User;
import org.example.pages.products.LandingPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

import static org.example.browser.LaunchOptionsProvider.getLaunchOptions;
import static org.example.browser.LaunchOptionsProvider.getPageOptions;
import static org.example.config.ConfigurationRetriever.getConfiguration;

@Log
public abstract class BaseTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;
    private static Integer appStatusCode;
    protected LandingPage landingPage;
    protected User user;

    @BeforeEach
    public void setUp() throws IOException {
        playwright = Playwright.create();
        if (getAppStatus() != 200) {
            log.severe("App is not available - tests will not run");
            System.exit(0);
        }
        browser = BrowserFactory.getBrowserType(playwright, getConfiguration().browser()).launch(getLaunchOptions());
        context = browser.newContext();
        page = browser.newPage(getPageOptions());
        page.navigate(getConfiguration().appUrl());
        landingPage = new LandingPage(page);
        user = User.getUser();
    }

    @AfterEach
    public void tearDown() {
        context.close();
        playwright.close();
    }

    private int getAppStatus() {
        if (appStatusCode == null) {
            appStatusCode = playwright.request().newContext().get(getConfiguration().appUrl()).status();
        }
        return appStatusCode;
    }
}
