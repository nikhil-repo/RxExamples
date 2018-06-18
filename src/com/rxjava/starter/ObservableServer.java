package com.rxjava.starter;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

import java.util.List;

public class ObservableServer {

	public static Observable<WeatherInfo> getWeatherInfo(List<String> cityAcronyms) {
	    
		return Observable.create(subscriber -> processRequest(subscriber,
				cityAcronyms));
	}

	
	
	/**
	 * 
	 * @param subscriber given a subscriber
	 * @param citySymbols the list of city names
	 * @throws InterruptedException 
	 */
    private static void processRequest(
            ObservableEmitter<WeatherInfo> subscriber, List<String> citySymbols) throws InterruptedException {

        System.out.println("Processing...");
        
//        subscriber.onError( new RuntimeException());

        /** 
         *  Java 7
         */
        while (true) {
            for (String sym : citySymbols) {
                subscriber.onNext(FetchWeather.fetch(sym));
                Thread.sleep(1000);
            }

        }
        
        /**
         * Java 8
         */
//        int count = 0;
//        while (count++ < 3) {
//            citySymbols.stream()
//                    .map(FetchWeather::fetch)
//                    .forEach(subscriber::onNext);
//        }
//        
//        subscriber.onComplete();

    }
    
	

}
