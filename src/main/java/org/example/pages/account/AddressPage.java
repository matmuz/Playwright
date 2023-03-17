package org.example.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.account.common.AccountPage;

import java.util.List;

public class AddressPage extends AccountPage {

    private final Locator addressBody;

    public AddressPage(Page page) {
        super(page);
        addressBody = page.locator(".address-body address");
    }

    public String getAddress() {
        return splitAddressBody()[1];
    }

    public String getPostalCode() {
        return splitAddressBody()[2].split(" ")[0];
    }

    public String getCity() {
        return splitAddressBody()[2].split(" ")[1];
    }

    public List<String> getAddressDetailsAsList() {
        return List.of(getAddress(), getPostalCode(), getCity());
    }

    private String[] splitAddressBody() {
        return addressBody.innerText().split("\n");
    }
}
