package com.rp.sec03.helper;

import com.rp.util.FakerUtil;
import reactor.core.publisher.FluxSink;

import java.util.function.Consumer;

public class NameProducer implements Consumer<FluxSink<String>> {

    private FluxSink<String> fluxSink;

    @Override
    public void accept(FluxSink<String> stringFluxSink) {
        this.fluxSink = stringFluxSink;
    }

    public void produce() {
        String name = FakerUtil.faker().funnyName().name();
        String threadName = Thread.currentThread().getName();
        this.fluxSink.next(threadName + " : " + name);
    }
}
