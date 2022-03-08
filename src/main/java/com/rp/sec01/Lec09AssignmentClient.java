package com.rp.sec01;

import com.rp.sec01.assignment.FileService;
import com.rp.util.SubscribeUtil;

public class Lec09AssignmentClient {

    public static void main(String[] args) {

        FileService.read("file1.txt")
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                        );

        FileService.read("file4.txt")
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );

        FileService.write("file3.txt", "test-file 03")
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );

        FileService.delete("file3.txt")
                .subscribe(
                        SubscribeUtil.onNext(),
                        SubscribeUtil.onError(),
                        SubscribeUtil.onComplete()
                );
    }
}
