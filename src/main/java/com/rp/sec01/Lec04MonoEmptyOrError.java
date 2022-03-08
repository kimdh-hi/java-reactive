package com.rp.sec01;

import com.rp.util.SubscribeUtil;
import com.rp.util.FakerUtil;
import reactor.core.publisher.Mono;

public class Lec04MonoEmptyOrError {

    public static void main(String[] args) {

        userRepository(1)
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );

        userRepository(2)
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );

        userRepository(3)
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );
    }

    private static Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just(FakerUtil.faker().name().firstName());
        } else if (userId == 2) {
            return Mono.empty(); // null XX
        } else {
            return Mono.error(new IllegalArgumentException("user Id error id= " + userId));
        }
    }
}
