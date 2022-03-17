package com.rp.sec02;

import com.rp.util.SubscribeUtil;
import com.rp.util.TimeSleepUtil;
import reactor.core.publisher.Flux;

import java.time.Duration;

public class Lec08FluxIntervals {

    public static void main(String[] args) {

        Flux.interval(Duration.ofSeconds(1))
                .subscribe(SubscribeUtil.onNext());

        TimeSleepUtil.sleepSeconds(5);
    }
}
