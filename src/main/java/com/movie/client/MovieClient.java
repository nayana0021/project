package com.movie.client;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.movie.dto.DailyBoxReq;
import com.movie.dto.DailyBoxRes;
import com.movie.dto.MovieDetailReq;
import com.movie.dto.MovieDetailRes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MovieClient {
	
	@Value("${movie.api.box.url}")
	private String boxUrl;
	
	@Value("${kmdb.api.detail.url}")
	private String kmdbUrl;
	
	@Value("${kmdb.api.key}")
	private String kmdbKey;
	
		 public DailyBoxRes reqBox(DailyBoxReq dailyBoxReq){
		    	URI uri = UriComponentsBuilder.fromUriString(boxUrl)  // https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json
		                .queryParams(dailyBoxReq.toMultiValueMap())  // key=f5eef3421c602c6cb7ea224104795888&targetDt=20230416
		                .encode()
		                .build()              
		                .toUri();
	
		        HttpHeaders headers = new HttpHeaders();      
		        headers.setContentType(MediaType.APPLICATION_JSON);
	
		        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);        
		        ParameterizedTypeReference<DailyBoxRes> responseType = new ParameterizedTypeReference<>(){};
		    
	
		        ResponseEntity<DailyBoxRes> responseEntity = new RestTemplate().exchange(
		                uri,
		                HttpMethod.GET,
		                httpEntity,
		                responseType
		        );
	
		        return responseEntity.getBody();
		    }
		 
	 
		 public MovieDetailRes reqDetail(MovieDetailReq movieDetailReq){
		    	URI uri = UriComponentsBuilder.fromUriString(kmdbUrl)  // 
		                .queryParams(movieDetailReq.tomulValueMap())  // 
		                .encode()
		                .build()              
		                .toUri();
	
		    	log.info("kmdb uri 확인"+uri);
		        HttpHeaders headers = new HttpHeaders();      
		        headers.setContentType(MediaType.APPLICATION_JSON);
	
		        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);        
		        
		        ResponseEntity<String> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = null;
				
				// 데이터 전체
				try {
					jsonObject = (JSONObject) jsonParser.parse(resEntity.getBody());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				//
				String movieName = (String) jsonObject.get("Query");	// 큰 데이터의 영화제목
				JSONArray jsonArray = (JSONArray) jsonObject.get("Data");	//	Data 데이터 전체
				JSONObject jsonItems=(JSONObject) jsonArray.get(0);			// Date 전체의 첫번째 객체
				JSONArray jsonArr= (JSONArray) jsonItems.get("Result");		// Result 데이터 전체
		
				JSONObject item = (JSONObject) jsonArr.get(0);	// Result 데이터의 첫번째 객체
				
				//directors
				JSONObject directors = (JSONObject) item.get("directors");	// 감독 객체
				JSONArray directorsArr = (JSONArray) directors.get("director");	// 감독 리스트
				JSONObject diretor = (JSONObject) directorsArr.get(0);		// 감독 리스트 중 첫번째 요소
				String directorNm = (String) diretor.get("directorNm");		// 감독 이름 스트링
				
				//actors
				JSONObject actors = (JSONObject) item.get("actors");	// 배우 객체
				JSONArray actorArr = (JSONArray) actors.get("actor");	// actor가 리스트임
				
				List<String> actorsList = new ArrayList<String>();	// 배우 정보를 담을 리스트
				
					for (Object object : actorArr) {	// "actor" 객체를 한 개(리스트)씩 돌릴거임
					
						JSONObject jsonObj = (JSONObject) object;	// 담음
						
						actorsList.add((String) jsonObj.get("actorNm"));	// 각 배우의 정보 리스트 중 이름 추출
					
					}
	
					JSONObject plots = (JSONObject) item.get("plots");
					JSONArray plotArr = (JSONArray) plots.get("plot");
					JSONObject plotOb = (JSONObject) plotArr.get(0);
					String plot = (String) plotOb.get("plotText");
					
					MovieDetailRes der = new MovieDetailRes();
					der.setTitle(movieName);
					der.setRepRlsDate(item.get("repRlsDate").toString());	
					der.setRating(item.get("rating").toString());
					der.setGenre(item.get("genre").toString());
					der.setRuntime(item.get("runtime").toString());
					der.setDirectorNm(directorNm);
					der.setActors(actorsList);
					der.setKeywords(item.get("keywords").toString());
					der.setAudiAcc(item.get("audiAcc").toString());
					der.setPlot(plot);	
					String posterUrl = (item.get("posters").toString());
					
					StringTokenizer st = new StringTokenizer(posterUrl,"|");
					der.setPosterUrl(st.nextToken());
										
					System.out.println(der);
					return der;
	
		}
	}