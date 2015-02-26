package modulePro.Editor.vo;

public class Project{
    private int    proUid       = 0;
    private int    proIterNum   = 0;
    private int    proStartTime = 0;
    private int    proLifeTime  = 0;
    private int    proTd        = 0;
	private String proFile		= "";
	private String proRegdate   = "";
	public int getProUid() {
		return proUid;
	}
	public void setProUid(int proUid) {
		this.proUid = proUid;
	}
	public int getProIterNum() {
		return proIterNum;
	}
	public void setProIterNum(int proIterNum) {
		this.proIterNum = proIterNum;
	}
	public int getProStartTime() {
		return proStartTime;
	}
	public void setProStartTime(int proStartTime) {
		this.proStartTime = proStartTime;
	}
	public int getProLifeTime() {
		return proLifeTime;
	}
	public void setProLifeTime(int proLifeTime) {
		this.proLifeTime = proLifeTime;
	}
	public int getProTd() {
		return proTd;
	}
	public void setProTd(int proTd) {
		this.proTd = proTd;
	}
	public String getProFile() {
		return proFile;
	}
	public void setProFile(String proFile) {
		this.proFile = proFile;
	}
	public String getProRegdate() {
		return proRegdate;
	}
	public void setProRegdate(String proRegdate) {
		this.proRegdate = proRegdate;
	}
	
}
