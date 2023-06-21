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
import com.movie.dto.MovieDetailDTO;
import com.movie.dto.MovieDetailReq;

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
	 
		 public void getPoster(MovieDetailReq movieDetailReq){
		    	URI uri = UriComponentsBuilder.fromUriString(kmdbUrl)  // https://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json
		                .queryParams(movieDetailReq.tomulValueMap())  // key=f5eef3421c602c6cb7ea224104795888&targetDt=20230416
		                .encode()
		                .build()              
		                .toUri();
	
		    	log.info("kmdb uri 확인"+uri);
		        HttpHeaders headers = new HttpHeaders();      
		        headers.setContentType(MediaType.APPLICATION_JSON);
	
		        HttpEntity<HttpHeaders> httpEntity = new HttpEntity<>(headers);        
//		        ParameterizedTypeReference<DailyBoxRes> responseType = new ParameterizedTypeReference<>(){};
//		    
//	
//		        ResponseEntity<DailyBoxRes> responseEntity = new RestTemplate().exchange(
//		                uri,
//		                HttpMethod.GET,
//		                httpEntity,
//		                responseType
//		        );
//	
//		        return responseEntity.getBody();
//		    }
		        
		        ResponseEntity<String> resEntity = new RestTemplate().exchange(uri, HttpMethod.GET, httpEntity, String.class);
				
				JSONParser jsonParser = new JSONParser();
				JSONObject jsonObject = null;
				
				try {
					jsonObject = (JSONObject) jsonParser.parse(resEntity.getBody());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				// 가장 큰 JSON 객체 response 가져오기
				String movieName = (String) jsonObject.get("Query");
				// System.out.println(movieName);
				
				
				JSONArray jsonArray = (JSONArray) jsonObject.get("Data");
		//		JSONArray jsonItems = (JSONArray) jsonArray.get(0);
				
				JSONObject jsonItems=(JSONObject) jsonArray.get(0);
				JSONArray jsonArr= (JSONArray) jsonItems.get("Result");
//				System.out.println(jsonArr);

//				List<MovieDetailDTO> list = new ArrayList<>();
				
//				for (Object object : jsonArr) {
//					System.out.println("데이터 확인 "+object);
					
					JSONObject item = (JSONObject) jsonArr.get(0);

					
					//directors
					JSONObject directors = (JSONObject) item.get("directors");
					JSONArray directorsArr = (JSONArray) directors.get("director");
					JSONObject diretor = (JSONObject) directorsArr.get(0);
					String directorNm = (String) diretor.get("directorNm");
					
					//actors
					JSONObject actors = (JSONObject) item.get("actors");
					JSONArray actorArr = (JSONArray) actors.get("actor");
					
					
					List<String> actorsList = new ArrayList<String>();
					
					for (Object object : actorArr) {
					
					JSONObject jsonObj = (JSONObject) object;
					
					actorsList.add((String) jsonObj.get("actorNm"));
					

					}
					
					
					
					
					
					MovieDetailDTO dto = new MovieDetailDTO();
					dto.setRuntime(item.get("runtime").toString());
					dto.setTitle(movieName);
					dto.setDirectorNm(directorNm);
					dto.setActors(actorsList);
					dto.setKeywords(item.get("keywords").toString());
//					dto.setPosterUrl(item.get("posters").toString().split("|"));
					String posterUrl = (item.get("posters").toString());
					
					StringTokenizer st = new StringTokenizer(posterUrl,"|");
					dto.setPosterUrl(st.nextToken());
					
					
//					dto.setMovieNm(item.get("movieNm").toString());
//					dto.setAudiAcc(item.get("audiAcc").toString());
//					dto.setMovieCd(item.get("movieCd").toString());
					
					System.out.println(dto);
//					list.add(dto);
//				}
	 
	 

		}
	}