package com.rxjava.starter;

import io.reactivex.Observable;

public class ObservableConditionalExample {
    private static Integer res = 0;

    public static void main(String[] s) {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
        Observable.fromArray(numbers)
                .takeWhile(i -> i < 5)
                .subscribe(onNext -> res += onNext);
        System.out.println("The result is : " + res);

        Observable.fromArray(numbers)
                .skipWhile(i -> i < 5)
                .subscribe(onNext -> res += onNext);
        System.out.println("The result is : " + res);
        

    }


}
