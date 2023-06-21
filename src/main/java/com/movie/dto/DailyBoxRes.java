package com.movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyBoxRes {

	private BoxOfficeResult boxOfficeResult = new BoxOfficeResult();	
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	public class BoxOfficeResult {
		//private String boxofficeType;
		//private String showRange;
		private List<DailyBoxOfficeList> dailyBoxOfficeList;		
	}	
}
