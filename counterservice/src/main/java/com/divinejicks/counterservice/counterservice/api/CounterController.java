package com.divinejicks.counterservice.counterservice.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class CounterController {

    private static AtomicLong count = new AtomicLong(0L);

    @Value(value = "${counter.prefixMessage}")
    private String prefixMessage;

    @GetMapping(path = "/count")
    public String getCount(){
        System.out.println(prefixMessage);
        return prefixMessage + count.getAndIncrement();
    }
}
