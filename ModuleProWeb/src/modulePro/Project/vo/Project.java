package modulePro.Project.vo;

import java.sql.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Project{
	/**
	 * 프로젝트 ID
	 */
	private int proID;
	
	/**
	 * 사용자 ID
	 */
	private String userID;
	
	/**
	 * 작성자
	 */
	@NotNull
	@Size(min=1,max=10)
	private String proUser;
	/**
	 * 평가자
	 */
	private String proAppraisal;
	/**
	 * 프로젝트명
	 */
	private String proName;
	
	/**
	 * 작성일자
	 */
	@NotNull(message="작성일을 입력해주세요.")
	private Date proStartDate;
	/**
	 * 평가일자
	 */
	
	private Date proEndDate;
	/**
	 * 저장경로
	 */
	private String proContact;
	/**
	 * 메모
	 */
	private String proMemo;
	/**
	 * 저장일
	 */
	private Date saveDate;
	
	
	
	public int getProID() {
		return proID;
	}
	public void setProID(int proID) {
		this.proID = proID;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getProUser() {
		return proUser;
	}
	public void setProUser(String proUser) {
		this.proUser = proUser;
	}
	public String getProAppraisal() {
		return proAppraisal;
	}
	public void setProAppraisal(String proAppraisal) {
		this.proAppraisal = proAppraisal;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public Date getProStartDate() {
		return proStartDate;
	}
	public void setProStartDate(Date proStartDate) {
		this.proStartDate = proStartDate;
	}
	public Date getProEndDate() {
		return proEndDate;
	}
	public void setProEndDate(Date proEndDate) {
		this.proEndDate = proEndDate;
	}
	public String getProContact() {
		return proContact;
	}
	public void setProContact(String proContact) {
		this.proContact = proContact;
	}
	public String getProMemo() {
		return proMemo;
	}
	public void setProMemo(String proMemo) {
		this.proMemo = proMemo;
	}
	public Date getSaveDate() {
		return saveDate;
	}
	public void setSaveDate(Date saveDate) {
		this.saveDate = saveDate;
	}
}
