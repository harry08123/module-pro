package modulePro.Member.vo;

import java.sql.Date;

public class Member {
	private String UserID;
	private int ProID;
	private int Division;
	private String UserName;
	private String Password;
	private Date SaveDate;
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public int getProID() {
		return ProID;
	}
	public void setProID(int proID) {
		ProID = proID;
	}
	public int getDivision() {
		return Division;
	}
	public void setDivision(int division) {
		Division = division;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public Date getSaveDate() {
		return SaveDate;
	}
	public void setSaveDate(Date saveDate) {
		SaveDate = saveDate;
	}
}
