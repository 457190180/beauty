package com.yimew.config.web;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class ReturnData implements Serializable {
	private static final long serialVersionUID = -5387203449885788924L;

	public ReturnData() {
	}

	public ReturnData(Object data, Integer code, String msg) {
		this.data = data;
		this.code = code;
		this.success = Const.CODE.SUCCESS == code ? true : false;
		this.date = new Date();
		this.msg = msg;
	}
	public ReturnData(Object data, Integer code) {
		this.data = data;
		this.code = code;
		this.success = Const.CODE.SUCCESS == code ? true : false;
		this.date = new Date();
	}
	public ReturnData( Integer code) {
		this.code = code;
		this.success = Const.CODE.SUCCESS == code ? true : false;
		this.date = new Date();
	}
	
	private Object data;
	private String msg;
	private Integer code;
	private Boolean success;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date date;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	@Override
	public String toString() {
		return "ReturnData [data=" + data + ", msg=" + msg + ", code=" + code + ", date=" + date + "]";
	}

}
