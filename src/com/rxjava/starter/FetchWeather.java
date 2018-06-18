package com.rxjava.starter;

import javax.management.RuntimeErrorException;

public class FetchWeather {

    /**
     * 
     * @param sym given a city symbol
     * @return a weatherInfo object
     */
	public static WeatherInfo fetch(String sym) {
		switch(sym){
		case "BOS" :
			double temp = generateRandomValue(-10, 20);
			return new WeatherInfo(sym, temp);
		case "BLORE" :
			double temp1 = generateRandomValue(10, 35);
			return new WeatherInfo(sym, temp1);
		case "SJC" :
			double temp2 = generateRandomValue(20, 45);
			return new WeatherInfo(sym, temp2);
		case "ABU" :
			double temp3 = generateRandomValue(30, 50);
			return new WeatherInfo(sym, temp3);
		 default:
			return null;
			
		}
		
	}

	/**
	 * 
	 * @param Min given a min number
	 * @param Max given a max number
	 * @return a random double in between the two ranges
	 */
	private static double generateRandomValue(int Min, int Max) {
	    if (Min >= Max) {
	        throw new RuntimeErrorException(null, "min has to be lesser than max");
	    }
		return Min + (int)(Math.random() * ((Max - Min) + 1));
	}

}
