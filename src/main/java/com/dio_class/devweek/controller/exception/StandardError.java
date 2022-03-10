package com.dio_class.devweek.controller.exception;

import java.io.Serializable;
import java.time.LocalDateTime;

public class StandardError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	Integer status;
	String msg;
	LocalDateTime timeStamp;
	
	public StandardError() {
	}

	public StandardError(Integer status, String msg, LocalDateTime localDate) {
		this.status = status;
		this.msg = msg;
		this.timeStamp = localDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	

}
