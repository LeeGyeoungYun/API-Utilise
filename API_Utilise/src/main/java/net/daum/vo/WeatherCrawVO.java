package net.daum.vo;

import lombok.Data;

@Data
public class WeatherCrawVO {
	
	private int wc_no;
	private String wc_region;
	private String wc_day;
	private String wc_date;
	private String wc_weather;
	private String wc_lowest;
	private String wc_highest;
	private String wc_creation_date;
	private String wc_modify_date;

}
