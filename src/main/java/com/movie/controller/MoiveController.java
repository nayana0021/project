package com.movie.controller;

import java.util.ArrayList;
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
@RequestMapping("/")
public class MoiveController {

	@Autowired
	private BoxOfficeService boxOfficeService;
	@Autowired
	private GetKmdbService getKmdbService;
	
	
	@GetMapping("/")
	public String main() {
		log.info("main 요청");
		return "redirect:/movie/box";
	}


	@GetMapping("/movie/box")
	public String view(Model model) {
	    log.info("박스오피스 요청");

	    List<DailyBoxOfficeList> list = boxOfficeService.view();
	    List<MovieDetailRes> details = new ArrayList<>();

		    for (DailyBoxOfficeList movie : list) {
		        MovieDetailRes detail = getKmdbService.detailView(movie.getMovieNm(), movie.getOpenDt().replaceAll("-", ""));
		        details.add(detail);
		    }
	
	    model.addAttribute("list", list);
	    model.addAttribute("details", details);

	    return "main";
	}
	
	
	  @GetMapping("/movie/movieDetail")
	  public String movieDetails(String movieNm, String openDt, Model model) {
//		  log.info("영화 상세 정보 이동 "+movieNm+openDt);
		  log.info("영화 상세 정보 이동 ");
		  String rOpenDt = openDt.replaceAll("-", "");
		  System.out.println(rOpenDt);
		  MovieDetailRes detail = getKmdbService.detailView(movieNm,rOpenDt);
		  
		  // detail 객체에 포스터 이미지 URL 정보 추가
		    String posterUrl = detail.getPosterUrl(); // 포스터 이미지 URL 가져오기
		    detail.setPosterUrl(posterUrl);
		  
		  model.addAttribute("detail", detail);
		  return "movie-details";
	  }
	
	  
}
