package org.example.base;

import com.microsoft.playwright.*;
import lombok.extern.java.Log;
import org.example.config.User;
import org.example.pages.products.LandingPage;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Path;

import static org.example.config.ConfigurationRetriever.getConfiguration;
import static org.example.constants.TestConstants.TRACES_DIR_PATH;
import static org.example.constants.TestConstants.ZIP_EXTENSION;

@Log
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    protected LandingPage landingPage;

    protected static User user;

    @BeforeAll
    public void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(getConfiguration().headless()));
    }

    @BeforeEach
    public void createContextAndPage() throws IOException {
        playwright = Playwright.create();
        context = browser.newContext(new Browser.NewContextOptions().setViewportSize(null));
        context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setSnapshots(true).setSources(false));
        Page page = context.newPage();
        page.navigate(getConfiguration().appUrl());
        landingPage = new LandingPage(page);
        user = User.getUser();
    }

    @AfterEach
    public void closeContext(TestInfo testInfo) {
        context.tracing().stop(new Tracing.StopOptions().setPath(Path.of(TRACES_DIR_PATH + testInfo.getDisplayName() + ZIP_EXTENSION)));
        context.close();
    }

    @AfterAll
    public void closeBrowser() {
        playwright.close();
    }
}