package com.rp.sec02.util;

import com.rp.util.FakerUtil;
import com.rp.util.TimeSleepUtil;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

public class NameGenerator {

    public static List<String> getNameList(int count) {
        List<String> names = new ArrayList<>();
        for (int i=0;i<count;i++) {
            names.add(getName());
        }
        return names;
    }

    public static Flux<String> getNameFlux(int count) {
        return Flux.range(0, count)
                .map(i -> getName());
    }

    private static String getName() {
        TimeSleepUtil.sleepSeconds(1);
        return FakerUtil.faker().name().fullName();
    }
}
