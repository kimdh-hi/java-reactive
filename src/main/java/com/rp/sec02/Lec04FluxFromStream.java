package com.rp.sec02;

import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec04FluxFromStream {

    public static void main(String[] args) {

        List<Integer> list = List.of(1, 2, 3, 4, 5);

        // Stream 재사용 시 발생하는 문제 해결 (매번 새로운 스트림이 생성되도록 처리)
        Flux<Integer> flux = Flux.fromStream(list::stream);

        flux.subscribe(SubscribeUtil.onNext(), SubscribeUtil.onError(), SubscribeUtil.onComplete());
        flux.subscribe(SubscribeUtil.onNext(), SubscribeUtil.onError(), SubscribeUtil.onComplete());
    }
}
