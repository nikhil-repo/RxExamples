package com.rxjava.starter;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ColdObservableExample {
    
    
    public static void main(String[] s) {
        Observable.range(1, 1_000_000)
        .observeOn(Schedulers.computation())
        .subscribe(ColdObservableExample::compute);
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public static void compute(Integer v) {
        try {
            System.out.println("compute integer v: " + v);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
