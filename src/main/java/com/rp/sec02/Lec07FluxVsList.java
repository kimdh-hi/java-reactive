package com.rp.sec02;

import com.rp.sec02.util.NameGenerator;
import com.rp.util.SubscribeUtil;
import reactor.core.publisher.Flux;

import java.util.List;

public class Lec07FluxVsList {

    public static void main(String[] args) {

        int count = 3;

        // count 초 만큼 작업 후 결과를 반환
        List<String> nameList = NameGenerator.getNameList(count);
        System.out.println(nameList);

        // 1초마다 생기는 결과를 반환
        // 결과가 만들어질 때마다 결과를 emit
        NameGenerator.getNameFlux(count)
                .subscribe(SubscribeUtil.onNext());

    }
}
