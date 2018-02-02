package heroDBPrac;

public class HeroDetailInfo {
	public HeroDetailInfo(String cname,int cpower,int cspeed,String comment) {
		this.ciName=cname;
		this.ciFower=cpower;
		this.ciSpeed=cspeed;
		this.Comment=comment;
				
	}
	public HeroDetailInfo() {
		// TODO Auto-generated constructor stub
	}
private String Comment;
private String ciName;
private int ciNum;
private int ciFower;
private int ciSpeed;
protected int getCiNum() {
	return ciNum;
}

protected void setCiNum(int ciNum) {
	this.ciNum = ciNum;
}

protected int getCiFower() {
	return ciFower;
}

protected void setCiFower(int ciFower) {
	this.ciFower = ciFower;
}

protected int getCiSpeed() {
	return ciSpeed;
}

protected void setCiSpeed(int ciSpeed) {
	this.ciSpeed = ciSpeed;
}

protected String getCiName() {
	return ciName;
}

protected void setCiName(String ciName) {
	this.ciName = ciName;
}

public String getComment() {
	return Comment;
}

protected void setComment(String comment) {
	Comment = comment;
}



}
