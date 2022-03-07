package com.rp.util;

import com.github.javafaker.Faker;
import reactor.core.scheduler.Schedulers;

public class FakerUtil {

    private static final Faker FAKER = Faker.instance();

    public static Faker faker() {
        return FAKER;
    }
}
