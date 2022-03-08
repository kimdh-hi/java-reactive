package com.rp.sec01;

import com.rp.util.SubscribeUtil;
import com.rp.util.TimeSleepUtil;
import reactor.core.publisher.Mono;

public class Lec08MonoFromRunnable {

    public static void main(String[] args) {

        Mono.fromRunnable(timeConsumingProcess())
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        () -> {
                            System.out.println("done");
                        });
    }

    private static Runnable timeConsumingProcess() {
        return () -> {
            TimeSleepUtil.sleepSeconds(3);
            System.out.println("operation ...");
        };
    }
}
