package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.dto.DailyBoxOfficeList;
import com.movie.service.BoxOfficeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class MoiveController {

	@Autowired
	private BoxOfficeService boxOfficeService;
	
	@GetMapping("/boxOffice/box")
	private List<DailyBoxOfficeList> view(){
		log.info("박스오피스 요청");
		return boxOfficeService.view();
	}
//	public String getImage() {
//		log.info("이미지 요청");
//		return 
//	}
	
}
