package com.mindtree.passport.entity;

public class Passport {
	private String passId;
	private String passNum;

	public Passport() {
		super();
	}

	public Passport(String passId, String passNum) {
		super();
		this.passId = passId;
		this.passNum = passNum;
	}

	public String getPassId() {
		return passId;
	}

	public void setPassId(String passId) {
		this.passId = passId;
	}

	public String getPassNum() {
		return passNum;
	}

	public void setPassNum(String passNum) {
		this.passNum = passNum;
	}

}
