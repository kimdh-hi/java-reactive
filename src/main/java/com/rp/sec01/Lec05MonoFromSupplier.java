package com.rp.sec01;

import com.github.javafaker.Faker;
import com.rp.util.ConsumerUtil;
import reactor.core.publisher.Mono;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class Lec05MonoFromSupplier {

    public static void main(String[] args) {

        // 아무도 구독하지 않았기 때문에 아무런 동작이 발생하지 않을 것으로 예상
        // but, getName()의 로그찍는 부분이 실행된다.
        // just 는 이미 갖고 있는 데이터를 emit 할 때만 사용하자.
        Mono<String> mono = Mono.just(getName());

        // 매개변수는 없고 리턴값을 갖는 메서드의 결과를 emit 하고자 할 때는 fromSupplier 를 사용하자.
        // 구독하기 전까지 getName() 자체가 호출되지 않는다.
        Mono<String> monoSupplier = Mono.fromSupplier(Lec05MonoFromSupplier::getName);
        // 구독할 때 실제 메서드가 호출되는 것을 확인
        monoSupplier.subscribe(
                ConsumerUtil.onNext(),
                ConsumerUtil.onError(),
                ConsumerUtil.onComplete()
        );

        Callable<String> callable = () -> getName();
        Mono.fromCallable(callable)
                .subscribe(
                        ConsumerUtil.onNext()
                );
    }

    private static String getName() {
        System.out.println("이름 생성..."); // 메서드가 호출되었는지 여부 확인용
        return Faker.instance().name().fullName();
    }
}
