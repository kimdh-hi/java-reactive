package com.rp.sec03;

import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec03FluxTake {

    public static void main(String[] args) {

        Flux.range(1, 10)
                .log()
                .take(3) // take(n) n개 만큼의 아이템 소비 흐 cancel 호출
                .log()
                .subscribe(SubscribeUtil.subscriber());
    }
}
