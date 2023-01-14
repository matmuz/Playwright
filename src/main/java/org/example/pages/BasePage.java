package org.example.pages;

import com.microsoft.playwright.Page;
import lombok.Getter;

@Getter
public abstract class BasePage {

    private final TopMenuPage topMenuPage;
    private final FooterPage footerPage;

    public BasePage(Page page) {
        this.topMenuPage = new TopMenuPage(page);
        this.footerPage = new FooterPage(page);
    }
}