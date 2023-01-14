package org.example.browser;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;

import java.util.List;

import static org.example.config.ConfigurationRetriever.getConfiguration;

public class LaunchOptionsProvider {

    public static BrowserType.LaunchOptions getLaunchOptions() {
        return new BrowserType.LaunchOptions()
                .setHeadless(getConfiguration().headless())
                .setArgs(List.of("--start-maximized", "--incognito"));
    }

    public static Browser.NewPageOptions getPageOptions() {
        return new Browser.NewPageOptions().setViewportSize(null);
    }
}
