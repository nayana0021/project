package com.movie.dto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.movie.client.MovieClient;
import com.movie.service.BoxOfficeService;

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
	private String releaseDts = "";
	private String ServiceKey = "247BM44236FJN9A9W484";
	
	public MovieDetailReq(String query, String releaseDts) {
		super();
		this.query = query;
		this.releaseDts = releaseDts;
	}

	
	public MultiValueMap<String, String> tomulValueMap(){
			var map = new LinkedMultiValueMap<String, String>();
		
		map.add("query", query);
		map.add("releaseDts", releaseDts);
		map.add("ServiceKey", ServiceKey);
		
//		log.info("query 확인: "+query+" detail 확인 : "+" movieNm 확인 : "+movieNm+"openDt 확인 : "+openDt);
		return map;
	}




	
}
