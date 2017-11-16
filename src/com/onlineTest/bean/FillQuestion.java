package com.onlineTest.bean;

public class FillQuestion {
	 private String fqId;
	
	private String fqTitle;
	private String fqAnswer;
	private String fqAnalysis;
	private String cid;

	public FillQuestion() {
	}

	public FillQuestion(String fqId, String fqTitle, String fqAnswer, String fqAnalysis, String cid) {
		this.fqId = fqId;
		this.fqTitle = fqTitle;
		this.fqAnswer = fqAnswer;
		this.fqAnalysis = fqAnalysis;
		this.cid = cid;

	}
	public String getFqId() {
		return fqId;
	}

	public void setFqId(String fqId) {
		this.fqId = fqId;
	}


	public String getFqTitle() {
		return fqTitle;
	}

	public void setFqTitle(String fqTitle) {
		this.fqTitle = fqTitle;
	}

	public String getFqAnswer() {
		return fqAnswer;
	}

	public void setFqAnswer(String fqAnswer) {
		this.fqAnswer = fqAnswer;
	}

	public String getFqAnalysis() {
		return fqAnalysis;
	}

	public void setFqAnalysis(String fqAnalysis) {
		this.fqAnalysis = fqAnalysis;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
