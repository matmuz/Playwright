package org.example.pages.common;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.helpers.CommonHelper;

@Getter
public abstract class BasePage {

    private final TopMenuPage topMenuPage;
    private final FooterPage footerPage;
    private final CommonHelper helper;

    public BasePage(Page page) {
        this.topMenuPage = new TopMenuPage(page);
        this.footerPage = new FooterPage(page);
        this.helper = new CommonHelper();
    }
}