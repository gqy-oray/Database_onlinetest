package com.onlineTest.bean;

public class ChoiceQuestion {

	private String id;
	private String title;
	private String choiceA;
	private String choiceB;
	private String choiceC;
	private String choiceD;
	private String answer;
	private String analysis;
	private String cid;

	public ChoiceQuestion() {
	}

	public ChoiceQuestion(String id, String title, String choiceA, String choiceB, String choiceC, String choiceD,
			String answer, String analysis, String cid) {
		this.id = id;
		this.title = title;
		this.choiceA = choiceA;
		this.choiceB = choiceB;
		this.choiceC = choiceC;
		this.choiceD = choiceD;
		this.answer = answer;
		this.analysis = analysis;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getChoiceA() {
		return choiceA;
	}

	public void setChoiceA(String choiceA) {
		this.choiceA = choiceA;
	}

	public String getChoiceB() {
		return choiceB;
	}

	public void setChoiceB(String choiceB) {
		this.choiceB = choiceB;
	}

	public String getChoiceC() {
		return choiceC;
	}

	public void setChoiceC(String choiceC) {
		this.choiceC = choiceC;
	}

	public String getChoiceD() {
		return choiceD;
	}

	public void setChoiceD(String choiceD) {
		this.choiceD = choiceD;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnalysis() {
		return analysis;
	}

	public void setAnalysis(String analysis) {
		this.analysis = analysis;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

}
