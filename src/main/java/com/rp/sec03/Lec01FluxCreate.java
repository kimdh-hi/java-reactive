package com.rp.sec03;

import com.github.javafaker.service.FakerIDN;
import com.rp.util.FakerUtil;
import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec01FluxCreate {

    public static void main(String[] args) {
        Flux.create(fluxSink -> {
            String country;
            do {
                country = FakerUtil.faker().country().name();
                fluxSink.next(country);
            } while (!country.toLowerCase().equals("korea, republic of"));

            fluxSink.complete();
        })
        .subscribe(SubscribeUtil.subscriber());
    }
}
