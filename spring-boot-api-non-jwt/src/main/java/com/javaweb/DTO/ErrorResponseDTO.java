package com.javaweb.DTO;

import java.util.List;
import java.util.ArrayList;

public class ErrorResponseDTO {
	private String errror;
	private List<String> detail = new ArrayList<>();
	public String getErrror() {
		return errror;
	}
	public void setErrror(String errror) {
		this.errror = errror;
	}
	public List<String> getDetail() {
		return detail;
	}
	public void setDetail(List<String> detail) {
		this.detail = detail;
	}
}
