package com.yashank.order_service.exception;

public class OutOfStockException extends RuntimeException {

	public OutOfStockException(String skuCode) {
		super("Product with SKU " + skuCode + " is not in stock");
	}

	public OutOfStockException(String message, Throwable cause) {
		super(message, cause);
	}
}


