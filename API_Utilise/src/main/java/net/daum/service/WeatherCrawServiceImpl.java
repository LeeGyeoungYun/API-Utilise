package net.daum.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import net.daum.dao.WeatherCrawDAO;
import net.daum.vo.WeatherCrawVO;

@Service
public class WeatherCrawServiceImpl implements WeatherCrawService {
	
	@Inject
	private WeatherCrawDAO weatherCrawDao;

	@Override
	public void insertWeatherData(WeatherCrawVO wc) {
		this.weatherCrawDao.insertWeatherData(wc);
	}

	@Override
	public int confirmWeatherData(WeatherCrawVO wc) {	
		return this.weatherCrawDao.confirmWeatherData(wc);
	}
	

}
