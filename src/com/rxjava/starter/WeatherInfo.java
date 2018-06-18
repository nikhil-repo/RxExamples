package com.rxjava.starter;

public class WeatherInfo {

	public final String cityCode;
	public final double temperature;
	
	/**
	 * 
	 * @param cityCode 
	 * @param temperature
	 */
	public WeatherInfo(String cityCode, double temperature){
		this.temperature = temperature;
		this.cityCode = cityCode;
	}

	@Override
	public String toString() {
		return "WeatherInfo [cityCode=" + cityCode + ", temperature=" + temperature + "]";
	}
}
