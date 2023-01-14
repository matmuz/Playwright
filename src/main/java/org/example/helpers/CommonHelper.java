package org.example.helpers;

import com.microsoft.playwright.ElementHandle;

import java.util.List;
import java.util.Random;

public class CommonHelper {

    private final Random random = new Random();

    public ElementHandle getRandomElementFromList(List<ElementHandle> list) {
        return list.get(random.nextInt(list.size()));
    }
}
