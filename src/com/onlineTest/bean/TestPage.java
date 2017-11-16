package com.onlineTest.bean;

public class TestPage {
	private int tpId;
	private String sno;
	private String cid;
	private int score;

	public TestPage() {
	}

	public TestPage(int tpId, String sno, String cid, int score) {
		this.tpId = tpId;
		this.sno = sno;
		this.cid = cid;
		this.score = score;
	}

	public int getTpId() {
		return tpId;
	}

	public void setTpId(int tpId) {
		this.tpId = tpId;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
