package com.rp.sec01;

import com.rp.util.SubscribeUtil;
import com.rp.util.FakerUtil;
import com.rp.util.TimeSleepUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;

public class Lec07MonoFromFuture {

    public static void main(String[] args) {
        Mono.fromFuture(() -> getName())
                .subscribe(SubscribeUtil.onNext());

        TimeSleepUtil.sleepSeconds(1);
    }

    private static CompletableFuture<String> getName() {
        return CompletableFuture.supplyAsync(() -> FakerUtil.faker().name().fullName());
    }
}
