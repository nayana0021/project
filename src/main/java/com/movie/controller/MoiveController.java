package com.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.movie.dto.DailyBoxOfficeList;
import com.movie.dto.DailyBoxRes;
import com.movie.dto.DailyBoxRes.BoxOfficeResult;
import com.movie.dto.MovieDetailRes;
import com.movie.service.BoxOfficeService;
import com.movie.service.GetKmdbService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/movie")
public class MoiveController {

	@Autowired
	private BoxOfficeService boxOfficeService;
	@Autowired
	private GetKmdbService getKmdbService;
	
	@GetMapping("/box")
	public String view(Model model){
		log.info("박스오피스 요청");
		
		List<DailyBoxOfficeList> list = boxOfficeService.view();
		
		model.addAttribute("list", list);
		return "main";
	}

//	  @GetMapping("/movie-details")
//	  public String goToMovieDetails() {
//		  log.info("영화 상세 페이지 요청");
//		  return "movie-details";
//	  }
	
	  @GetMapping("/movieDetail")
	  public String movieDetails(String movieNm, String openDt, Model model) {
		  log.info("영화 상세 정보 이동 "+movieNm+openDt);
		  String rOpenDt = openDt.replaceAll("-", "");
		  System.out.println(rOpenDt);
		  MovieDetailRes detail = getKmdbService.detailView(movieNm,openDt);
		  model.addAttribute("detail", detail);
		  
		  return "movie-details";
	  }
	  
//	  public 
	  
}
