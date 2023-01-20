package org.example.pages.common;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.account.SignInPage;
import org.example.pages.products.SearchResultsPage;

public class TopMenuPage {

    private final Page page;
    private final Locator shopLogo;
    private final Locator userIcon;
    private final Locator account;
    private final Locator signOut;
    private final Locator searchInput;
    private final Locator searchIcon;

    public TopMenuPage(Page page) {
        this.page = page;
        this.shopLogo = page.locator("img.logo");
        this.userIcon = page.locator(".user-info .material-icons");
        this.account = page.locator(".account");
        this.signOut = page.locator("a.logout");
        this.searchInput = page.locator("input[aria-label='Search']");
        this.searchIcon = page.locator("button[type='Submit']");
    }

    public boolean isUsernameVisible() {
        return account.isVisible();
    }

    public boolean isShopLogoVisible() {
        return shopLogo.isVisible();
    }

    public boolean isSearchInputHighlighted() {
        return false;
    }

    public String getLoggedInAccount() {
        return account.innerText();
    }

    public TopMenuPage signOut() {
        signOut.click();
        return this;
    }

    public TopMenuPage typeTextToSearchInput(String text) {
        searchInput.type(text);
        return this;
    }

    public SearchResultsPage clickOnSearchIcon() {
        searchIcon.click();
        return new SearchResultsPage(page);
    }

    public SignInPage goToSignInSection() {
        userIcon.click();
        return new SignInPage(page);
    }
}
