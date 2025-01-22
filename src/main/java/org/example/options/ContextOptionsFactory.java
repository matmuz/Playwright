package org.example.options;

import com.microsoft.playwright.Browser;

public class ContextOptionsFactory {

    public static Browser.NewContextOptions getContextOptions() {
        return new Browser.NewContextOptions().setViewportSize(1920, 1080);
    }
}
