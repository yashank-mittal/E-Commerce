package com.yashank.order_service.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(OutOfStockException.class)
	public ResponseEntity<Map<String, Object>> handleOutOfStock(OutOfStockException ex) {
		Map<String, Object> body = new HashMap<>();
		body.put("timestamp", Instant.now().toString());
		body.put("status", HttpStatus.CONFLICT.value());
		body.put("error", HttpStatus.CONFLICT.getReasonPhrase());
		body.put("message", ex.getMessage());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
	}
}


