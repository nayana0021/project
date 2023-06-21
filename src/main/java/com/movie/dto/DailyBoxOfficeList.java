package com.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyBoxOfficeList {
	private int rank;
	private String movieNm;
	private String openDt;
	private int audiAcc;
}
