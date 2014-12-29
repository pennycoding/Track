package com.fightfive.track.information;

/*
 * 个人信息
 */
public class Information {

	/**
	 * 学生学号
	 */
	private String sid;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 班级名称
	 */
	private String class_name;

	/**
	 * 手机号码
	 */
	private String phone;

	/**
	 * Email地址
	 */
	private String email;

	/**
	 * 公司名称
	 */
	private String company_name;

	/**
	 * 公司地址
	 */
	private String company_address;

	/**
	 * 更新时间
	 */
	private String modify_time;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClass_name() {
		return class_name;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCompany_address() {
		return company_address;
	}

	public void setCompany_address(String company_address) {
		this.company_address = company_address;
	}

	public String getModify_time() {
		return modify_time;
	}

	public void setModify_time(String modify_time) {
		this.modify_time = modify_time;
	}
}
