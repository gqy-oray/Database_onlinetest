package com.onlineTest.bean;

public class JudgleQuestion {
	private String jqId;
	private String jqTitle;
	private String jqAnswer;
	private String jqAnalysis;
	private String cid;

	public JudgleQuestion() {
	}

	public JudgleQuestion(String jqId, String jqTitle, String jqAnswer, String jqAnalysis, String cid) {
		this.jqId = jqId;
		this.jqTitle = jqTitle;
		this.jqAnswer = jqAnswer;
		this.jqAnalysis = jqAnalysis;
		this.cid = cid;
	}

	public String getJqId() {
		return jqId;
	}

	public void setJqId(String jqId) {
		this.jqId = jqId;
	}

	public String getJqTitle() {
		return jqTitle;
	}

	public void setJqTitle(String jqTitle) {
		this.jqTitle = jqTitle;
	}

	public String getJqAnswer() {
		return jqAnswer;
	}

	public void setJqAnswer(String jqAnswer) {
		this.jqAnswer = jqAnswer;
	}

	public String getJqAnalysis() {
		return jqAnalysis;
	}

	public void setJqAnalysis(String jqAnalysis) {
		this.jqAnalysis = jqAnalysis;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
