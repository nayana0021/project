package com.movie.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.movie.client.MovieClient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailReq {

	@Autowired
	private MovieClient movieClient;
	@Autowired
	private DailyBoxReq req;
	@Autowired
	private DailyBoxRes res;
	
	private String query = "";
	private String detail = "Y";
	private String releaseDts = "";
	private String ServiceKey = "247BM44236FJN9A9W484";
	
	public MultiValueMap<String, String> tomulValueMap(){
		var map = new LinkedMultiValueMap<String, String>();
		
//		String movieNm = movieClient.reqBox(req).getBoxOfficeResult().getDailyBoxOfficeList().get(0).getMovieNm();
//		String openDt = movieClient.reqBox(req).getBoxOfficeResult().getDailyBoxOfficeList().get(0).getOpenDt();
//		System.out.println(openDt);
//		openDt.replaceAll("-", "");
//		System.out.println(openDt);
		map.add("query", "범죄도시3");
		map.add("detail", detail);
		map.add("ServiceKey", ServiceKey);
		
//		log.info("query 확인: "+query+" detail 확인 : "+detail+" movieNm 확인 : "+movieNm+"openDt 확인 : "+openDt);
		return map;
	}
	
}
