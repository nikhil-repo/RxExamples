package com.rxjava.starter;

import io.reactivex.Observable;

public class ObservableFlatMapExample {


    public static void main(String[] s) {

        Observable<String> source = Observable.just("Rx is aysnchronous programming paradigm", "They help to manipulate streams");

        source.map(String::trim)
                .flatMap(onEach -> {
                    String[] words = onEach.split("\\s+");
                    return Observable.fromArray(words);
                })
                .subscribe(onNext -> printValues(onNext));

    }

    private static void printValues(String onNext) {
       System.out.println(onNext);
    }

}
