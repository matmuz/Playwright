package org.example.options;

import com.microsoft.playwright.BrowserType;

import static org.example.config.ConfigurationRetriever.getConfiguration;

public class LaunchOptionsFactory {

    public static BrowserType.LaunchOptions getLaunchOptions() {
        return new BrowserType.LaunchOptions().setHeadless(getConfiguration().headless());
    }
}
