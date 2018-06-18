package com.rxjava.starter;

import io.reactivex.Observable;

public class ObservableMapExample {
    
    private static String res = "";

    public static void main(String[] s) {

        String[] strings = { "  a", " bx ", " tc", "d", "e", "f" };
        Observable.fromArray(strings)
                .map(String::trim)
                .map(String::toUpperCase)
                .subscribe(onNext -> res  += onNext);
        
        System.out.println(res);
    }
}
