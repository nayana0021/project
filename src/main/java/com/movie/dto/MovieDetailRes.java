package com.movie.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailRes {
	private String title;	//영화명
	private String repRlsDate;	//대표개봉일
	private String rating;	//대표관람등급
	private String genre;	//장르
	private String runtime;	//상영시간
	private String directorNm;	//감독명
	private List<String> actors=new ArrayList<String>();	//배우명 actors
	private String keywords;	//키워드
	private String audiAcc;	//누적관람인원
	private String plot;	//줄거리
	private String posterUrl;	//포스터이미지
}
