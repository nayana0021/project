package com.movie.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDetailRes {

	private String Query;
	private String KMAQuery;
	private String TotalCount;
	private List<Data> Data;
	
	public class Data{
		private String CollName;
		private int TotalCount;
		private int Count;
		private List<Result> Result;
		
		public class Result{
			
			
			
		}
	}
}
