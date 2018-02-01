package heroDBPrac;

public class HeroDetailInfo {
private String Comment;
private String ciName;
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
