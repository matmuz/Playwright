package org.example.pages.base;

import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.helpers.CommonHelper;
import org.example.pages.footer.FooterPage;
import org.example.pages.menus.TopMenuPage;

@Getter
public abstract class BasePage {

    private final CommonHelper helper;
    private final TopMenuPage topMenuPage;
    private final FooterPage footerPage;

    public BasePage(Page page) {
        this.topMenuPage = new TopMenuPage(page);
        this.footerPage = new FooterPage(page);
        this.helper = new CommonHelper();
    }
}