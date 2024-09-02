package com.cpt.payments.service.http;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class HttpServiceEngine {
	
	private RestTemplate restTemplate;
	
	public HttpServiceEngine(RestTemplate restTemplate) {
		this.restTemplate=restTemplate;
	}
	
	public <T> ResponseEntity<T> makeHttpRequest(
			String url,
			HttpMethod method,
			Object 	request,
			Class<T> responseType,
			Map<String, String> headers
			){
		try {
			HttpHeaders httpHeaders = new HttpHeaders();
			if(headers!=null) {
				headers.forEach(httpHeaders::set);
			}
			HttpEntity<Object> entity = new HttpEntity<>(request,httpHeaders);
			ResponseEntity<T> httpResponse = restTemplate.exchange(url, method,entity,responseType);
			System.out.println("we got http response as : "+httpResponse);
			return httpResponse;
		}
		catch(HttpClientErrorException | HttpServerErrorException ex) {
			System.out.println("we got error as : "+ex);
			return ResponseEntity.status(ex.getStatusCode()).body(null);
		}
		catch(Exception ex) {
			System.out.println("from general exception we got error as : "+ex);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
		
	}
}
