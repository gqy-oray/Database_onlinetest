package com.onlineTest.bean;

public class Score {

	  private String sno;
	    private String cid;
	    private int score;
	    
	    public Score(){}
	    public Score(String sno,String cid,int score){
	    	this.sno=sno;
	    	this.cid=cid;
	    	this.score=score;
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
