package com.rp.sec03;

import com.rp.util.FakerUtil;
import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec04FluxCreateIssueFix {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
                    String country;
                    do {
                        country = FakerUtil.faker().country().name();
                        System.out.println("emitting country: " + country);
                        fluxSink.next(country);
                    } while (!country.toLowerCase().equals("korea, republic of") && !fluxSink.isCancelled()); // take만큼 처리 후 cancel이 호출되면  emitting 을 종료하도록 처리

                    fluxSink.complete();
                })
                .take(3) // 3개만 Receive 후 Complete 호출
                .subscribe(SubscribeUtil.subscriber());
    }
}
