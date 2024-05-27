package com.project.banking.app.Exception;

import java.util.Objects;

public class ErrResponse {

	private String errResponseCode;
	private String errResponseerror;

	public ErrResponse(String errResponseCode, String errResponseerror) {
		super();
		this.errResponseCode = errResponseCode;
		this.errResponseerror = errResponseerror;
	}

	public ErrResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ErrResponse [errResponseCode=" + errResponseCode + ", errResponseerror=" + errResponseerror + "]";
	}

	public String getErrResponseCode() {
		return errResponseCode;
	}

	public void setErrResponseCode(String errResponseCode) {
		this.errResponseCode = errResponseCode;
	}

	public String getErrResponseerror() {
		return errResponseerror;
	}

	public void setErrResponseerror(String errResponseerror) {
		this.errResponseerror = errResponseerror;
	}

}
