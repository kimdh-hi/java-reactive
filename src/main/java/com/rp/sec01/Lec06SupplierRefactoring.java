package com.rp.sec01;

import com.rp.util.SubscribeUtil;
import com.rp.util.FakerUtil;
import com.rp.util.TimeSleepUtil;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class Lec06SupplierRefactoring {

    public static void main(String[] args) {

        getName();
        getName()
                .subscribeOn(Schedulers.boundedElastic()) // 2. 비동기화
                .subscribe(SubscribeUtil.onNext()); // 1. subscribe => blocking
        getName();

        TimeSleepUtil.sleepSeconds(5); // 비동기 처리된 결과를 받고 Thread 를 종료시키기 위해 sleep
    }

    private static Mono<String> getName() {
        System.out.println("getName() 호출");
        return Mono.fromSupplier(() -> {
            System.out.println("이름 생성...");
            TimeSleepUtil.sleepSeconds(3);
            return FakerUtil.faker().name().fullName();
        }).map(String::toUpperCase)
                .map(name -> name.replace(" ", "-"));
    }
}
