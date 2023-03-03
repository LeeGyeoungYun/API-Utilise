package net.daum.service;

import net.daum.vo.WeatherCrawVO;

public interface WeatherCrawService {
	
	void insertWeatherData(WeatherCrawVO wc);
	int confirmWeatherData(WeatherCrawVO wc);
	
}
