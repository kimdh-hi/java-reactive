package com.rp.sec02;

import com.rp.util.TimeSleepUtil;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.Flux;

import java.util.concurrent.atomic.AtomicReference;

public class Lec06Subscription {

    public static void main(String[] args) {


        /**
         * AtomicReference : synchronized 보다 적은 비용으로 동시성 보장
         */
        AtomicReference<Subscription> atomicReference = new AtomicReference<>();

        Flux.range(1, 20)
                .subscribeWith(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        System.out.println("Received Sub : " + subscription);
                        atomicReference.set(subscription);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        System.out.println("onNext: " + integer);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        System.out.println("onError: " + throwable.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("onComplete");
                    }
                });

        TimeSleepUtil.sleepSeconds(3);
        atomicReference.get().request(3);

        TimeSleepUtil.sleepSeconds(3);
        atomicReference.get().request(3);

        TimeSleepUtil.sleepSeconds(3);
        System.out.println("cancel");
        atomicReference.get().cancel();

        // cancel() 이후 요청은 실행되지 않음
        TimeSleepUtil.sleepSeconds(3);
        atomicReference.get().request(3);
        TimeSleepUtil.sleepSeconds(3);
    }
}
