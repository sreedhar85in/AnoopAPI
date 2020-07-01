package com.openapi.model;

import java.util.Date;

import lombok.Data;

@Data
public class Timeresponse {
	
	private int outcomeCode = 200;
	
	private String date ; 
	
	private String outcomeMessage = "Success";

	
	

}
