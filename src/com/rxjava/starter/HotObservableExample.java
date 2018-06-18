package com.rxjava.starter;

import java.util.stream.IntStream;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;

public class HotObservableExample {
    
    public static void main(String[] s) {
        PublishSubject<Integer> source = PublishSubject.<Integer>create();
        
        source.buffer(1024).subscribeOn(Schedulers.computation())
          .subscribe();
         
        IntStream.range(1, 1_000_000).forEach(source::onNext);
        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void compute(Integer v) {
        try {
            System.out.println("compute integer v: " + v);
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
