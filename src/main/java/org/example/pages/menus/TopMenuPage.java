package org.example.pages.menus;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.helpers.CommonHelper;
import org.example.pages.account.SignInPage;
import org.example.pages.cart.CartPage;
import org.example.pages.help.ContactUsPage;
import org.example.pages.products.LandingPage;
import org.example.pages.products.ProductsPage;
import org.example.pages.products.SearchResultsPage;
import org.example.pages.products.enums.ItemsSections;

import java.util.List;

public class TopMenuPage {

    private final CommonHelper helper;
    private final Page page;
    private final Locator shopLogo;
    private final Locator userIcon;
    private final Locator account;
    private final Locator signOut;
    private final Locator searchInput;
    private final Locator searchIcon;
    private final Locator shoppingCartIcon;
    private final Locator contactUsLink;
    private final List<ElementHandle> categories;

    public TopMenuPage(Page page) {
        this.helper = new CommonHelper();
        this.page = page;
        this.shopLogo = page.locator("img.logo");
        this.userIcon = page.locator(".user-info .material-icons");
        this.account = page.locator(".account");
        this.signOut = page.locator("a.logout");
        this.searchInput = page.locator("input[aria-label='Search']");
        this.searchIcon = page.locator("button[type='Submit']");
        this.shoppingCartIcon = page.locator("a .shopping-cart");
        this.contactUsLink = page.locator("#contact-link");
        this.categories = page.querySelectorAll("#top-menu .category");
    }

    public boolean isUsernameVisible() {
        return account.isVisible();
    }

    public boolean isShopLogoVisible() {
        return shopLogo.isVisible();
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

    public CartPage goToShoppingCart() {
        shoppingCartIcon.click();
        return new CartPage(page);
    }

    public LandingPage goToLandingPage() {
        shopLogo.click();
        return new LandingPage(page);
    }

    public ContactUsPage goToContactUsPage() {
        contactUsLink.click();
        return new ContactUsPage(page);
    }

    public ProductsPage goToItemsSection(ItemsSections itemSection) {
        switch (itemSection) {
            case CLOTHES:
            case ACCESSORIES:
            case ART:
                clickOnSection(itemSection);
                return new ProductsPage(page);
            case MEN:
            case WOMEN:
                hoverOverSection(ItemsSections.CLOTHES);
                waitForSubcategory(itemSection);
                clickOnSection(itemSection);
                return new ProductsPage(page);
            case STATIONERY:
            case HOME_ACCESSORIES:
                hoverOverSection(ItemsSections.ACCESSORIES);
                waitForSubcategory(itemSection);
                clickOnSection(itemSection);
                return new ProductsPage(page);
            default:
                throw new IllegalArgumentException("Unsupported items section selected");
        }
    }

    private void hoverOverSection(ItemsSections itemsSection) {
        categories.stream().filter(element -> element.innerText().equals(itemsSection.getName()))
                  .collect(helper.toSingleton()).hover();
    }

    private void clickOnSection(ItemsSections itemsSection) {
        categories.stream().filter(element -> element.innerText().equals(itemsSection.getName()))
                  .collect(helper.toSingleton()).click();
    }

    private void waitForSubcategory(ItemsSections itemsSection) {
        switch (itemsSection) {
            case MEN:
                page.locator("#category-4").waitFor();
                break;
            case WOMEN:
                page.locator("#category-5").waitFor();
                break;
            case STATIONERY:
                page.locator("#category-7").waitFor();
                break;
            case HOME_ACCESSORIES:
                page.locator("#category-8").waitFor();
                break;
            default:
                throw new IllegalArgumentException("Unsupported item section selected");
        }
    }
}