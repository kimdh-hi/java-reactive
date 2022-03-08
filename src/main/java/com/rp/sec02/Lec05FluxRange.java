package com.rp.sec02;

import com.rp.util.FakerUtil;
import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec05FluxRange {

    public static void main(String[] args) {

        // range(start, count) : start 부터 count 개 item 발행 (1씩 증가)
        Flux.range(1, 10)
                .subscribe(SubscribeUtil.onNext());

        // Faker 와 range 를 이용해서 10개 이름 발행
        Flux.range(1, 10)
                .map(i -> FakerUtil.faker().name().fullName())
                .subscribe(SubscribeUtil.onNext());
    }
}
