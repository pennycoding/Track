package com.fightfive.track.diary;

/*
 * �ܼ�
 */
public class Diary {

	/**
	 * �ܴ�
	 */
	private int week_id;

	/**
	 * ѧ��ѧ��
	 */
	private String sid;

	/**
	 * ʵϰ����
	 */
	private String content;

	/**
	 * ʵϰ�ջ�
	 */
	private String harvest;

	/**
	 * ����ͽ���
	 */
	private String suggestion;

	/**
	 * �Ƿ����ϴ�
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
