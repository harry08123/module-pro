package modulePro.Engine.vo;

import java.util.ArrayList;

public class Sampleform {
		private double ranNum;
		private float present;
		private float availability = 0f;
		private float availabilityAll = 0f;
		private double hazardRate;
		private float impFailure = 0f;
		private float impRepair = 0f;
		private float minMttf;
		private float maxMttf;
		private float mostMttf;
		private float breakpoint;
		private float timeDelay;
		private boolean repearState;
		private float[][] resultArr;
		private float[] totavaArr;
		private float[] iterationArr;
		private String[][] stepAve;
		private float yeartotRoof;
		private float totRoof;
		private float yearAvailability;
		private float totAvailability;
		private int fmcont;
		private float flaring;
		private String failState;
		private boolean generalState;
		private int 		 iteration;
		private int         lifeTime;
		private float		 td;
		private float step;
		private String[] stepFigName;
		private ArrayList<int[][]> brakeArr;
		
		////////////////////////
	    private int    proUid       = 0;
	    private String proCode      = "";
	    private String proName      = "";
	    private String proJob       = "";
	    private String proClient    = "";
	    private String proContact   = "";
	    private String proNote      = "";
	    private String proOriginator= "";
	    private String proCheckBy   = "";
	    private String proId        = "";
	    private String proRegdate   = "";
	    
	    private int    proTd;
	    
	    
		public ArrayList<int[][]> getBrakeArr() {
			return brakeArr;
		}
		public void setBrakeArr(ArrayList<int[][]> breakList) {
			this.brakeArr = breakList;
		}
		public String[] getStepFigName() {
			return stepFigName;
		}
		public void setStepFigName(String[] stepFigName) {
			this.stepFigName = stepFigName;
		}
		public float getStep() {
			return step;
		}
		public void setStep(float step) {
			this.step = step;
		}
		public String[][] getStepAve() {
			return stepAve;
		}
		public void setStepAve(String[][] stepAve) {
			this.stepAve = stepAve;
		}
		public double getRanNum() {
			return ranNum;
		}
		public void setRanNum(double ranNum) {
			this.ranNum = ranNum;
		}
		public float getPresent() {
			return present;
		}
		public void setPresent(float present) {
			this.present = present;
		}
		public float getAvailability() {
			return availability;
		}
		public void setAvailability(float availability) {
			this.availability = availability;
		}
		public float getAvailabilityAll() {
			return availabilityAll;
		}
		public void setAvailabilityAll(float availabilityAll) {
			this.availabilityAll = availabilityAll;
		}
		public double getHazardRate() {
			return hazardRate;
		}
		public void setHazardRate(double hazardRate) {
			this.hazardRate = hazardRate;
		}
		public float getImpFailure() {
			return impFailure;
		}
		public void setImpFailure(float impFailure) {
			this.impFailure = impFailure;
		}
		public float getImpRepair() {
			return impRepair;
		}
		public void setImpRepair(float impRepair) {
			this.impRepair = impRepair;
		}
		public float getMinMttf() {
			return minMttf;
		}
		public void setMinMttf(float minMttf) {
			this.minMttf = minMttf;
		}
		public float getMaxMttf() {
			return maxMttf;
		}
		public void setMaxMttf(float maxMttf) {
			this.maxMttf = maxMttf;
		}
		public float getMostMttf() {
			return mostMttf;
		}
		public void setMostMttf(float mostMttf) {
			this.mostMttf = mostMttf;
		}
		public float getBreakpoint() {
			return breakpoint;
		}
		public void setBreakpoint(float breakpoint) {
			this.breakpoint = breakpoint;
		}
		public float getTimeDelay() {
			return timeDelay;
		}
		public void setTimeDelay(float timeDelay) {
			this.timeDelay = timeDelay;
		}
		public boolean isRepearState() {
			return repearState;
		}
		public void setRepearState(boolean repearState) {
			this.repearState = repearState;
		}
		public float[][] getResultArr() {
			return resultArr;
		}
		public void setResultArr(float[][] resultArr) {
			this.resultArr = resultArr;
		}
		public float[] getTotavaArr() {
			return totavaArr;
		}
		public void setTotavaArr(float[] totavaArr) {
			this.totavaArr = totavaArr;
		}
		public float[] getIterationArr() {
			return iterationArr;
		}
		public void setIterationArr(float[] iterationArr) {
			this.iterationArr = iterationArr;
		}
		public float getYeartotRoof() {
			return yeartotRoof;
		}
		public void setYeartotRoof(float yeartotRoof) {
			this.yeartotRoof = yeartotRoof;
		}
		public float getTotRoof() {
			return totRoof;
		}
		public void setTotRoof(float totRoof) {
			this.totRoof = totRoof;
		}
		public float getYearAvailability() {
			return yearAvailability;
		}
		public void setYearAvailability(float yearAvailability) {
			this.yearAvailability = yearAvailability;
		}
		public float getTotAvailability() {
			return totAvailability;
		}
		public void setTotAvailability(float totAvailability) {
			this.totAvailability = totAvailability;
		}
		public int getFmcont() {
			return fmcont;
		}
		public void setFmcont(int fmcont) {
			this.fmcont = fmcont;
		}
		public float getFlaring() {
			return flaring;
		}
		public void setFlaring(float flaring) {
			this.flaring = flaring;
		}
		public String getFailState() {
			return failState;
		}
		public void setFailState(String failState) {
			this.failState = failState;
		}
		public boolean isGeneralState() {
			return generalState;
		}
		public void setGeneralState(boolean generalState) {
			this.generalState = generalState;
		}
		public int getIteration() {
			return iteration;
		}
		public void setIteration(int iteration) {
			this.iteration = iteration;
		}
		public int getLifeTime() {
			return lifeTime;
		}
		public void setLifeTime(int lifeTime) {
			this.lifeTime = lifeTime;
		}
		public float getTd() {
			return td;
		}
		public void setTd(float td) {
			this.td = td;
		}
		public int getProUid() {
			return proUid;
		}
		public void setProUid(int proUid) {
			this.proUid = proUid;
		}
		public String getProCode() {
			return proCode;
		}
		public void setProCode(String proCode) {
			this.proCode = proCode;
		}
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public String getProJob() {
			return proJob;
		}
		public void setProJob(String proJob) {
			this.proJob = proJob;
		}
		public String getProClient() {
			return proClient;
		}
		public void setProClient(String proClient) {
			this.proClient = proClient;
		}
		public String getProContact() {
			return proContact;
		}
		public void setProContact(String proContact) {
			this.proContact = proContact;
		}
		public String getProNote() {
			return proNote;
		}
		public void setProNote(String proNote) {
			this.proNote = proNote;
		}
		public String getProOriginator() {
			return proOriginator;
		}
		public void setProOriginator(String proOriginator) {
			this.proOriginator = proOriginator;
		}
		public String getProCheckBy() {
			return proCheckBy;
		}
		public void setProCheckBy(String proCheckBy) {
			this.proCheckBy = proCheckBy;
		}
		public String getProId() {
			return proId;
		}
		public void setProId(String proId) {
			this.proId = proId;
		}
		public String getProRegdate() {
			return proRegdate;
		}
		public void setProRegdate(String proRegdate) {
			this.proRegdate = proRegdate;
		}
		public int getProTd() {
			return proTd;
		}
		public void setProTd(int proTd) {
			this.proTd = proTd;
		}
	    
}
