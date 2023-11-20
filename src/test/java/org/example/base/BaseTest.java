package org.example.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.example.pages.products.LandingPage;
import org.example.users.RandomUser;
import org.example.users.User;
import org.junit.jupiter.api.*;

import java.io.IOException;

import static org.example.config.ConfigurationRetriever.getConfiguration;
import static org.example.options.ContextOptionsFactory.getContextOptions;
import static org.example.options.LaunchOptionsFactory.getLaunchOptions;
import static org.example.options.TracingOptionsFactory.getStartOptions;
import static org.example.options.TracingOptionsFactory.getStopOptions;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected LandingPage landingPage;

    protected static User user;
    protected RandomUser randomUser;

    @BeforeAll
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(getLaunchOptions());
    }

    @BeforeEach
    public void createContextAndPage() throws IOException {
        playwright = Playwright.create();
        context = browser.newContext(getContextOptions());
        context.tracing().start(getStartOptions());
        Page page = context.newPage();
        page.navigate(getConfiguration().appUrl());
        landingPage = new LandingPage(page);
        user = User.getUser();
        randomUser = new RandomUser.Builder().firstName().lastName().email().build();
    }

    @AfterEach
    public void closeContext(TestInfo testInfo) {
        context.tracing().stop(getStopOptions(testInfo.getDisplayName()));
        context.close();
    }

    @AfterAll
    public void closeBrowser() {
        playwright.close();
    }
}