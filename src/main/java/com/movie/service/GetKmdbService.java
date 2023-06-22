package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.movie.client.MovieClient;
import com.movie.dto.DailyBoxOfficeList;
import com.movie.dto.DailyBoxReq;
import com.movie.dto.DailyBoxRes;
import com.movie.dto.MovieDetailReq;
import com.movie.dto.MovieDetailRes;

@Service
public class GetKmdbService {
	
	
	@Autowired
	private MovieClient movieClient;
	
	public MovieDetailRes detailView(String movieNm, String openDt) {
		
		MovieDetailReq req = new MovieDetailReq(movieNm,openDt);
		MovieDetailRes res = movieClient.reqDetail(req);
		
		return res;
	}
	
	
}
