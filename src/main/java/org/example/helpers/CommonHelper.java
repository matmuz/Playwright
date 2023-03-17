package org.example.helpers;

import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class CommonHelper {

    private final Random random;

    public CommonHelper() {
        this.random = new Random();
    }

    public <T> T getRandomElementFromList(List<T> list) {
        return list.get(random.nextInt(list.size()));
    }

    public <T> Collector<T, ?, T> toSingleton() {
        return Collectors.collectingAndThen(Collectors.toList(), list -> {
            if (list.size() != 1) {
                throw new IllegalStateException("There is more than one element found - there should be only one");
            }
            return list.get(0);
        });
    }
}