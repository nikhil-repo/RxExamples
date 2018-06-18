package com.rxjava.starter;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;import org.reactivestreams.Subscriber;



public class ObserverClient {
    public static void main(String[] s) throws InterruptedException {

        List<String> cityAchronyms = Arrays.asList("BOS", "ABU", "BLORE", "SJC");

        Observable<WeatherInfo> getWeatherInfo = ObservableServer.getWeatherInfo(cityAchronyms);
        System.out.println("Got observable...");
        
//        getWeatherInfo.subscribe(onNext -> processData(onNext), onError -> printError(onError), () -> System.out.println("Completed"));
        
        /**
         * Using Schedulers to asynchronously process the data
         */

        getWeatherInfo.subscribeOn(Schedulers.newThread())
                .subscribe(onNext -> processData(onNext), onError -> printError(onError), () -> System.out.println("Completed"));

        /**
         * controlling the iteration
         */
       
//        getWeatherInfo.subscribeWith(new DisposableObserver<WeatherInfo>() {
//
//            @Override
//            public void onNext(WeatherInfo onNext) {
//                System.out.println(onNext);
//                if (onNext.cityCode.equals("BOS") && onNext.temperature >= 15) {
//                    System.out.println("I am going to the beach ... :) ");
//                    dispose();
//                }
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                // TODO Auto-generated method stub
//                
//            }
//
//            @Override
//            public void onComplete() {
//                // TODO Auto-generated method stub
//                
//            }
//        });
        
        /**
         * Schedulers
         */
        
//        getWeatherInfo.subscribeOn(Schedulers.io()).subscribe(onNext -> processData(onNext));
        
        Thread.sleep(10000);
    }
    
    /**
     * 
     * @param onNext given a value from the observable
     * @return
     */
	private static void processData(WeatherInfo onNext) {
	    System.out.println(Thread.currentThread());
        System.out.println(onNext);
    }

    private static void printError(Throwable onError) {
        System.out.println("Error Occured in the source " + onError);
    }

}
