package com.pokedex.domain.models;


import java.util.Date;

public class Response {
	
	private Date timestamp;		
	private String data;		
	private int respondeCode;		
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getRespondeCode() {
		return respondeCode;
	}
	public void setRespondeCode(int respondeCode) {
		this.respondeCode = respondeCode;
	}

	
	
	public Response(String data, int respondeCode) {			
		this.timestamp = new Date();			
		this.data = data;			
		this.respondeCode = respondeCode;			
	}
	

}
