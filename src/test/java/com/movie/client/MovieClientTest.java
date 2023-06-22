package com.movie.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.movie.dto.DailyBoxReq;
import com.movie.dto.DailyBoxRes;
import com.movie.dto.MovieDetailReq;


@SpringBootTest
public class MovieClientTest {

	@Autowired
	private MovieClient movieClient;
	
	@Test
	public void	boxOfficeTest() {
		
		DailyBoxReq req = new DailyBoxReq();
		
		DailyBoxRes res = movieClient.reqBox(req);
		
		System.out.println(res.getBoxOfficeResult().getDailyBoxOfficeList().get(1).getMovieNm());
		
	}
	
//	@Test
//	public void movieNameTest() {
//		
//		MovieDetailReq req = new MovieDetailReq();
//		
//		movieClient.reqDetail(req);
//		
//		
//		
//	}

	
	
//	@Test
//	public void searchImageTest() {
//		
//		SearchImageReq req = new SearchImageReq();
//		req.setQuery("갈비");
//		
//		
//		SearchImageRes res = naverClient.searchImage(req);
//		System.out.println(res);
//	}
}
