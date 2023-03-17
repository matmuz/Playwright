package org.example.pages.footer;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class FooterPage {

    private final Locator footerSection;

    public FooterPage(Page page) {
        this.footerSection = page.locator("#footer");
    }

    public boolean isFooterSectionVisible() {
        return footerSection.isVisible();
    }
}
