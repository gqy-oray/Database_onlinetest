package com.onlineTest.bean;

public class Question {
	private String qid;
	private int tpId;
	private int qType;
	private String inputAnswer;

	public Question() {
	}

	public Question(String qid, int tpId, int qType, String inputAnswer) {
		this.qid = qid;
		this.tpId = tpId;
		this.qType = qType;
		this.inputAnswer = inputAnswer;
	}

	public String getQid() {
		return qid;
	}

	public void setQid(String qid) {
		this.qid = qid;
	}

	public int getTpId() {
		return tpId;
	}

	public void setTpId(int tpId) {
		this.tpId = tpId;
	}

	public int getqType() {
		return qType;
	}

	public void setqType(int qType) {
		this.qType = qType;
	}

	public String getInputAnswer() {
		return inputAnswer;
	}

	public void setInputAnswer(String inputAnswer) {
		this.inputAnswer = inputAnswer;
	}

}
