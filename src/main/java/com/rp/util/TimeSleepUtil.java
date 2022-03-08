package com.rp.util;

import java.util.concurrent.TimeUnit;

public class TimeSleepUtil {

    public static void sleepSeconds(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
