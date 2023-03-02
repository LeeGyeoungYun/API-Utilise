package net.daum.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.daum.vo.WeatherCrawVO;

@Repository
public class WeatherCrawDAOImpl implements WeatherCrawDAO {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void insertWeatherData(WeatherCrawVO wc) {
		this.sqlSession.insert("insertWeaterData",wc);	
	}
	
	

}
