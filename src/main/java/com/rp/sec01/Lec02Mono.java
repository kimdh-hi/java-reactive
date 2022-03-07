package com.rp.sec01;

import reactor.core.publisher.Mono;

public class Lec02Mono {

    public static void main(String[] args) {

        // publisher
        Mono<Integer> mono = Mono.just(1);

        //  구독하기 전까지는 아무 일이 없다.
        System.out.println(mono);

        // 구독 후 출력
        mono.subscribe(i -> System.out.println("Received: " + i));

    }
}
