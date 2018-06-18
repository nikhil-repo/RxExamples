package com.rxjava.starter;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

class PrintSubscriber implements Subscriber<Object>{
    private final String name;
    public PrintSubscriber(String name) {
        this.name = name;
    }
   
    @Override
    public void onError(Throwable e) {
        System.out.println(name + ": Error: " + e);
    }
    @Override
    public void onNext(Object v) {
        System.out.println(name + ": " + v);
        
    }
    @Override
    public void onSubscribe(Subscription s) {
        //ToDO
        
    }
    @Override
    public void onComplete() {
        System.out.println(name + ": Completed");
        
    }
}
