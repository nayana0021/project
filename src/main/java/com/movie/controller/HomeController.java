package com.movie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@GetMapping("/")
	public String main() {
		log.info("main 요청");
		return "main";
	}
	
	  @GetMapping("/movie-details")
	  public String goToMovieDetails() {
		  log.info("영화 상세 페이지 요청");
		  return "movie-details";
	  }
	
	 
}
