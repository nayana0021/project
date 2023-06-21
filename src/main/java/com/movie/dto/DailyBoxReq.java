package com.movie.dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyBoxReq {
	
	private String key = "353227e02895bcc0e75346f1ae218935";	
	
	LocalDate yesterday = LocalDate.now().minusDays(1);	
	private String targetDt = yesterday.format(DateTimeFormatter.ofPattern("YYYYMMdd"));
    
    public MultiValueMap<String, String> toMultiValueMap(){
        var map = new LinkedMultiValueMap<String, String>();

        map.add("key",key);
        map.add("targetDt",targetDt);
       log.info("key 확인 "+key+" targetDt 확인 "+targetDt);
        return map;
    }
}
