package com.rp.sec01;

import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Lec01Stream {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1)
                .map(i -> {
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return i*2;
                });

        /**
         * 결과출력 XX Lazy Stream
         */
//        System.out.println(stream);

        /**
         * 원소출력 OK
         */
        stream.forEach(System.out::println);
    }
}
