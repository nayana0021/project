package com.movie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movie.dto.MovieDetailRes;
import com.movie.service.GetKmdbService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class HomeController {

	@Autowired
	private GetKmdbService getKmdbService;
	
	@GetMapping("/")
	public String main() {
		log.info("main 요청");
		return "redirect:/movie/box";
	}
	
	
	 
}
