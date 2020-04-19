package org.spring.revision.springmicroservicerevision.bean;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("PersonAddressFilter")
public class SomeJsonIgnoreBeanBinamic {

	private String string;
	private String string2;	
	private String string3;
	
	
	
	public SomeJsonIgnoreBeanBinamic(String string, String string2, String string3) {
	
		this.string = string;
		this.string2 = string2;
		this.string3 = string3;
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public String getString2() {
		return string2;
	}
	public void setString2(String string2) {
		this.string2 = string2;
	}
	public String getString3() {
		return string3;
	}
	public void setString3(String string3) {
		this.string3 = string3;
	}
	@Override
	public String toString() {
		return "SomeJsonIgnoreBeanBinamic [string=" + string + ", string2=" + string2 + ", string3=" + string3 + "]";
	}
	
	
}
