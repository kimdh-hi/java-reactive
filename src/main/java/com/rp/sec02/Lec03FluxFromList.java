package com.rp.sec02;

import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Lec03FluxFromList {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("a", "b", "c", "d");
        // just 로 한 개씩 발헹
        Flux.fromIterable(list)
                .subscribe(SubscribeUtil.onNext());

        Integer[] arr = {1, 2, 3, 4};
        Flux.fromArray(arr)
                .subscribe(SubscribeUtil.onNext());
    }
}
