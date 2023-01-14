package org.example.pages;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Page;
import lombok.Getter;

import java.util.List;

@Getter
public class LandingPage extends BasePage {

    private final List<ElementHandle> products;

    public LandingPage(Page page) {
        super(page);
        this.products = page.querySelectorAll(".thumbnail-container");
    }
}