package org.example.pages.account.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.account.YourAccountPage;
import org.example.pages.common.BasePage;

public abstract class AccountBasePage extends BasePage {

    private final Page page;
    private final Locator pageHeader;
    private final Locator yourAccountLink;

    public AccountBasePage(Page page) {
        super(page);
        this.page = page;
        this.pageHeader = page.locator(".page-header");
        this.yourAccountLink = page.locator("a[href*='account'] span[itemprop='name']");
    }

    public String getPageHeader() {
        return pageHeader.innerText();
    }

    public YourAccountPage goBackToYourAccountPage() {
        yourAccountLink.click();
        return new YourAccountPage(page);
    }
}
