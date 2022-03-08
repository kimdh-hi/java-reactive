package com.rp.sec02;

import reactor.core.publisher.Flux;

public class Lec02MultiSubscriber {

    public static void main(String[] args) {
        // Flux 생성
        Flux<Integer> flux = Flux.just(1, 2, 3, 4);
        // Flux 필터링
        Flux<Integer> filteredFlux = flux.filter(i -> i % 2 == 0);

        flux.subscribe(i -> System.out.println("Sub 1 : " + i));

        filteredFlux.subscribe(i -> System.out.println("Sub 2 : " + i));
    }
}
