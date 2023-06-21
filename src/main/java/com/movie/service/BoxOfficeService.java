package com.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.client.MovieClient;
import com.movie.dto.DailyBoxOfficeList;
import com.movie.dto.DailyBoxReq;
import com.movie.dto.DailyBoxRes;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class BoxOfficeService {
	
	@Autowired
	private MovieClient movieClient;	
	
    public List<DailyBoxOfficeList> view(){
    	
        // 영화진흥위원회 정보 가져오기
    	DailyBoxReq req = new DailyBoxReq();
		
    	DailyBoxRes res = movieClient.reqBox(req);
        return res.getBoxOfficeResult().getDailyBoxOfficeList();
    }  
    
}

