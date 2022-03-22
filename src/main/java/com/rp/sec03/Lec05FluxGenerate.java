package com.rp.sec03;

import com.rp.util.FakerUtil;
import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

public class Lec05FluxGenerate {

    public static void main(String[] args) {
        // synchronousSink 한 개의 데이터만 emit 가능
        // 한 개 데이터를 emit 하고 이후 데이더를 emit해야하는 경우 에러 발생
        Flux.generate(synchronousSink -> {
            System.out.println("emitting...");
            synchronousSink.next(FakerUtil.faker().country().name());
//            synchronousSink.next(FakerUtil.faker().country().name()); // Error
            synchronousSink.complete();
        })
                .take(2)
                .subscribe(SubscribeUtil.subscriber());
    }
}
