package com.rp.sec01;

import com.rp.util.ConsumerUtil;
import reactor.core.publisher.Mono;

public class Lec03MonoSubscribe {

    public static void main(String[] args) {

        // publisher
        Mono<String> mono = Mono.just("test");

        // subscribe 1 - subscribe (onNext, onError, onComplete)
        mono.subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed")
        );


        // publisher - error 발생
        Mono<Integer> monoError = Mono.just("test")
                .map(String::length)
                .map(len -> len / 0);

        // onError 부분에 대한 처리를 명시하지 않으면 그냥 예외가 터진다.
        monoError.subscribe(
                System.out::println,
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed")
        );


        // Util 클래스 사용
        mono.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );
    }
}
