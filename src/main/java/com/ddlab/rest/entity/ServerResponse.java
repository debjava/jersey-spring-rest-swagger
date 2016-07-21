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

@XmlRootElement(name = "ServerResponse")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder={"status", "message"})
@JsonPropertyOrder(value={"status", "message"})
@ApiModel(value = "ServerResponse", description = "Custom response from server")
public class ServerResponse {
	
	@XmlElement(name = "status")
	@JsonProperty("status")
	@ApiModelProperty(name="status", value = "status", dataType = "java.lang.String")
	private String status;
	
	@XmlElement(name = "message")
	@JsonProperty("message")
	@ApiModelProperty(name="message", value = "message", dataType = "java.lang.String")
	private String message;
	
	public ServerResponse(String status,String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}
	
	

}
