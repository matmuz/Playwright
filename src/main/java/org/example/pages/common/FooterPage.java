package org.example.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public class FooterPage {

    private final Locator footerSection;

    public FooterPage(Page page) {
        this.footerSection = page.locator("#footer");
    }
}
