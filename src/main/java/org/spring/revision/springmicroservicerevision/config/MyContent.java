package org.spring.revision.springmicroservicerevision.config;

import java.time.LocalDate;

import springfox.documentation.service.Contact;

public class MyContent extends Contact {
private String desc;
private LocalDate date;
	public MyContent(String name, String url, String data, String desc, LocalDate date) {
		super(name, url, data+"\n "+desc+" \n"+date);
		this.date = date;
		this.desc = desc;
	}
	
	public MyContent(String name, String url, String email) {
		super(name, url, email);
	
	}

	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "MyContent [desc=" + desc + ", date=" + date + "]";
	}


}
