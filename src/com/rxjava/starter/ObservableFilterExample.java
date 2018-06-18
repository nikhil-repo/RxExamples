package com.rxjava.starter;

import io.reactivex.Observable;

public class ObservableFilterExample {

    private static Integer res = 0;

    public static void main(String[] s) {

        Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };
        Observable.fromArray(numbers)
                .filter(num -> (num % 2 == 0))
                .subscribe(onNext -> res  += onNext);
        
        System.out.println("The result is : " + res);
    }
    

}
