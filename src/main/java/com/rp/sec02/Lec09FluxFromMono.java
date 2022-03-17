package com.rp.sec02;

import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Lec09FluxFromMono {

    public static void main(String[] args) {

//        Mono<String> mono = Mono.just("test");
//
//        Flux.from(mono)
//                .subscribe(SubscribeUtil.onNext());

        Flux.range(1, 5)
                .filter(i -> i == 3)
                .next()
                .subscribe(SubscribeUtil.onNext(), SubscribeUtil.onError(), SubscribeUtil.onComplete());
    }
}
