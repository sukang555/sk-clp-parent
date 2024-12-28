package com.skse.serverio;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class ClientServer {
	
	
	public static void main(String[] args) throws Exception {
		TemporalAccessor temporalAccessor = DateTimeFormatter.ofPattern("yyyyMMdd").parse("20210601");
		LocalDate localDate = LocalDate.from(temporalAccessor);

		System.out.println(localDate);
	}

}
