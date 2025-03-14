//package com.chenna.service;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//
//@Service
//public class SummaryService 
//{
//	 @Value("${openai.api.key}")
//	    private String apiKey;
//
//	    public String generateSummary(String content) {
//	        RestTemplate restTemplate = new RestTemplate();
//
//	        Map<String, String> request = new HashMap<>();
//	        request.put("model", "gpt-4");
//	        request.put("prompt", "Summarize this content: " + content);
//	        request.put("max_tokens", "100");
//
//	        return restTemplate.postForObject(
//	            "https://api.openai.com/v1/completions",
//	            request,
//	            String.class
//	        );
//	    }
//}
