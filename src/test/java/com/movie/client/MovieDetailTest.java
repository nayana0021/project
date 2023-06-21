package com.movie.client;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import com.movie.client.MovieClient;
import com.movie.dto.DailyBoxReq;
import com.movie.dto.DailyBoxRes;
import com.movie.dto.MovieDetailReq;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class MovieDetailTest {

	@Autowired
	private MovieClient movieClient;
	
	
		@Test
		public void movieNameTest() {
			
			DailyBoxReq req = new DailyBoxReq();
			
			DailyBoxRes res = movieClient.reqBox(req);
			
			System.out.println(res.getBoxOfficeResult().getDailyBoxOfficeList().get(0).getMovieNm());
			
			
		}
	
//		@Test
//		public void movieNameTest() {
//			
//			MovieDetailReq req = new MovieDetailReq();
//			
//			movieClient.getPoster(req);
			
//			System.out.println(res.getBoxOfficeResult().getDailyBoxOfficeList().get(0).getMovieNm());
			
			
//		}

	
		
//		public MultiValueMap<String, String> tomulValueMap(){
//		var map = new LinkedMultiValueMap<String, String>();
//		
//		String movieNm = movieClient.reqBox(req).getBoxOfficeResult().getDailyBoxOfficeList().get(0).getMovieNm();
//		
//		map.add("query", movieNm);
//		map.add("detail", detail);
//		
//		log.info("query 확인: "+query+" detail 확인 : "+detail+" movieNm 확인 : "+movieNm);
//		return map;
//	
//	
//	}

	}

