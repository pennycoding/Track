package com.fightfive.track.diary;

/*
 * 周记
 */
public class Diary {

	/**
	 * 周次
	 */
	private int week_id;

	/**
	 * 学生学号
	 */
	private String sid;

	/**
	 * 实习内容
	 */
	private String content;

	/**
	 * 实习收获
	 */
	private String harvest;

	/**
	 * 意见和建议
	 */
	private String suggestion;

	/**
	 * 是否已上传
	 */
	private String is_upload;

	public int getWeek_id() {
		return week_id;
	}

	public void setWeek_id(int week_id) {
		this.week_id = week_id;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getHarvest() {
		return harvest;
	}

	public void setHarvest(String harvest) {
		this.harvest = harvest;
	}

	public String getSuggestion() {
		return suggestion;
	}

	public void setSuggestion(String suggestion) {
		this.suggestion = suggestion;
	}

	public String getIs_upload() {
		return is_upload;
	}

	public void setIs_upload(String is_upload) {
		this.is_upload = is_upload;
	}
}
