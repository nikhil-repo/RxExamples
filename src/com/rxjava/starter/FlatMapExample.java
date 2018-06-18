package com.rxjava.starter;

import io.reactivex.Observable;

public class FlatMapExample {
    
    public static void main(String s[]) {
        Observable<String> values = Observable.just("a", "b", "c", "d");

        values
            .flatMap(str -> prefix(str)).
            flatMap(str -> postfix(str)).subscribe();
          
    }

    private static Observable<Object> postfix(Object str) {
        System.out.println("Inside postfix... ");
        System.out.println("Thread inside postfix :" + Thread.currentThread());
        str = str + "x";
        System.out.println("postfix value :" + str);
        return Observable.just(str);
    }

    private static Observable<Object> prefix(String str) {
       System.out.println("Inside prefix... ");
       System.out.println("Thread inside prefix :" + Thread.currentThread());
       str = "x" + str;
       System.out.println("prefix value :" + str);
       return Observable.just(str);
       
    }
}
