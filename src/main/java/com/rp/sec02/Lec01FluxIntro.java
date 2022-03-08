package com.rp.sec02;

import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec01FluxIntro {

    public static void main(String[] args) {

        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        flux.subscribe(SubscribeUtil.onNext(), SubscribeUtil.onError(), SubscribeUtil.onComplete());
    }
}
