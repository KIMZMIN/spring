package com.yedam.app.rent.service;

import lombok.Data;

@Data
public class RentVO {
	private int bookNo;
	private String bookName;
	private int price;
	private String status;
}
