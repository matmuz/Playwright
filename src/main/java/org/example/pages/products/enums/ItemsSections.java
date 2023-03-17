package org.example.pages.products.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemsSections {

    CLOTHES("CLOTHES"),
    ACCESSORIES("ACCESSORIES"),
    ART("ART"),
    MEN("MEN"),
    WOMEN("WOMEN"),
    STATIONERY("STATIONERY"),
    HOME_ACCESSORIES("HOME ACCESSORIES");

    private final String name;
}
