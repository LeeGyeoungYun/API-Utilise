package net.daum.dao;

import net.daum.vo.WeatherCrawVO;

public interface WeatherCrawDAO {
	
	void insertWeatherData(WeatherCrawVO wc);
	int confirmWeatherData(WeatherCrawVO wc);

}
