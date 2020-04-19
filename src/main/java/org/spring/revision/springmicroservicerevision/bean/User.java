package org.spring.revision.springmicroservicerevision.bean;

import java.net.URI;
import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description=" the model class that act as the user entity")
public class User {

	@NotNull
	private int id;
	@NotNull
	private String name;
	@ApiModelProperty(notes="date cannot be in the past")
	@Past(message="date should be in the past")
	private LocalDate date;

	public User() {

	}

	public User(int id, String name, LocalDate date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}

}
