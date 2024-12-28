package com.skse.se.design.behavioral.Templat;

public class TemplatContest extends Templat {

	@Override
	public void doPost(String string) {
		
		String replaceAll = string.replaceAll("\\.json", "");
		
		System.out.println(replaceAll);
	}

}
