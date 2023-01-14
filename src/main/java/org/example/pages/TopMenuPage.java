package org.example.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;

public class TopMenuPage {

    private final Page page;
    @Getter
    private final Locator shopLogo;
    private final Locator userIcon;
    private final Locator account;

    public TopMenuPage(Page page) {
        this.page = page;
        this.shopLogo = page.locator("img.logo");
        this.userIcon = page.locator(".user-info .material-icons");
        this.account = page.locator(".account");
    }

    public SignInPage goToSignInSection() {
        userIcon.click();
        return new SignInPage(page);
    }

    public String getLoggedInAccount() {
        return account.innerText();
    }
}
