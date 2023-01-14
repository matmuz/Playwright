package org.example.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import lombok.Getter;
import org.example.pages.account.SignInPage;

public class TopMenuPage {

    private final Page page;
    @Getter
    private final Locator shopLogo;
    private final Locator userIcon;
    private final Locator account;
    private final Locator signOut;

    public TopMenuPage(Page page) {
        this.page = page;
        this.shopLogo = page.locator("img.logo");
        this.userIcon = page.locator(".user-info .material-icons");
        this.account = page.locator(".account");
        this.signOut = page.locator("a.logout");
    }

    public boolean isUsernameVisible() {
        return account.isVisible();
    }

    public String getLoggedInAccount() {
        return account.innerText();
    }

    public TopMenuPage signOut() {
        signOut.click();
        return this;
    }

    public SignInPage goToSignInSection() {
        userIcon.click();
        return new SignInPage(page);
    }
}
