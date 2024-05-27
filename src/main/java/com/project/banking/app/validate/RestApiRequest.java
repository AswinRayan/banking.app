package com.project.banking.app.validate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RestApiRequest {

	public static final ObjectMapper objectMapper = new ObjectMapper();

	public static <T> T validateRequest(String request, Class<T> type)
			throws JsonMappingException, JsonProcessingException {
		return objectMapper.readValue(request, type);

	}
}
