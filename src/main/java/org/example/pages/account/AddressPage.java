package org.example.pages.account;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.example.pages.account.common.AccountBasePage;

import java.util.HashMap;
import java.util.Map;

public class AddressPage extends AccountBasePage {

    private final Locator addressBody;

    public AddressPage(Page page) {
        super(page);
        addressBody = page.locator(".address-body address");
    }

    public Map<String, String> getAddressBody() {
        String[] addressDetails = addressBody.innerText().split("\n");
        String[] postalCodeAndCity = addressDetails[2].split(" ");
        Map<String, String> addressMap = new HashMap<>();
        addressMap.put("address", addressDetails[1]);
        addressMap.put("postalCode", postalCodeAndCity[0]);
        addressMap.put("city", postalCodeAndCity[1]);
        return addressMap;
    }
}
