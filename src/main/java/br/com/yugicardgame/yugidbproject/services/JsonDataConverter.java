package br.com.yugicardgame.yugidbproject.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataConverter {
	
	private ObjectMapper mapper = new ObjectMapper();

	public <T> T getJsonData(String data, Class<T> classOfT){
		
		try {
			return mapper.readValue(data, classOfT);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
