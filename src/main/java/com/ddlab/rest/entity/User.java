package com.ddlab.rest.entity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@XmlRootElement(name = "User")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"userName", "password","id"})
@JsonPropertyOrder(value={"userName", "password", "id"})
@ApiModel(value = "User", description = "User description")
public class User {
	
	@XmlElement(name = "username")
	@JsonProperty("username")
	@ApiModelProperty(name="username", value = "username", dataType = "java.lang.String", required = true)
	private String userName;
	
	@XmlElement(name = "password")
	@JsonProperty("password")
//	@ApiModelProperty(value = "password", required=true)
	@ApiModelProperty(name = "password", value = "password", dataType = "java.lang.String", required = true)
	private String password;
	
	@XmlElement(name = "id")
	@JsonProperty("id")
	@ApiModelProperty(name="id", dataType = "java.lang.Integer", required=false)
	private int id;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
