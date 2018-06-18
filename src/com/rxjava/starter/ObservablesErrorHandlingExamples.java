package com.rxjava.starter;

import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;

public class ObservablesErrorHandlingExamples {

    private static String value = "value";

    @SuppressWarnings({ "unchecked", "static-access" })
    public static void main(String[] s) {
        
        //Example 1: perform some action on error
        /**
        AtomicBoolean state = new AtomicBoolean(false);
        @SuppressWarnings("rawtypes")
        TestObserver testObserver = new TestObserver();
        Observable.just("Hello")
                .error(new RuntimeException())
                .doOnError(throwable -> {
                    state.set(true);
                    value = "newValue";
                })
                .subscribe(testObserver);

        testObserver.assertNotComplete();
        testObserver.assertNoValues();
        System.out.println("The current state:" + state.get());
        System.out.println("The current value:" + value);
        **/

        //Example 2: send default values
        /**
        TestObserver testObserver = new TestObserver();
        Observable.just("Hello")
                .error(new RuntimeException())
                .onErrorReturnItem("Default Value")
                .subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValueCount(1);
        testObserver.assertValue("Default Value");
        **/
        
        // Example 3 : subscribe to a new service
        /**
        TestObserver testObserver = new TestObserver();
        Observable
        .error(new RuntimeException())
          .onErrorResumeNext(Observable.just("one", "two"))
          .subscribe(testObserver);
     
        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValueCount(2);
        testObserver.assertValues("one", "two");
        **/
    }

}
