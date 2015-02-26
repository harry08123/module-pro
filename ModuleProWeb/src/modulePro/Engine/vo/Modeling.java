package modulePro.Engine.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import modulePro.Editor.vo.Project;

public class Modeling{
	
	public Modeling(){}
	
	public  Modeling(String prdUid){
		setMoProject(Integer.parseInt(prdUid));
	}
	
	public Modeling(Project project){
	    this.setMoProject(project.getProUid());
	}
	
	private int moUid;
	private int moProject;
	private String moName;
	private String moType;
	private String moSx;
	private String moSy;
	private String moEx;
	private String moEy;
	private String moColor;
	private String mo_width;
	private String mo_height;
	private String mo_rardius;
	private String mo_persons;
	public int getMoUid() {
		return moUid;
	}

	public void setMoUid(int moUid) {
		this.moUid = moUid;
	}

	public int getMoProject() {
		return moProject;
	}

	public void setMoProject(int moProject) {
		this.moProject = moProject;
	}

	public String getMoName() {
		return moName;
	}

	public void setMoName(String moName) {
		this.moName = moName;
	}

	public String getMoType() {
		return moType;
	}

	public void setMoType(String moType) {
		this.moType = moType;
	}

	public String getMoSx() {
		return moSx;
	}

	public void setMoSx(String moSx) {
		this.moSx = moSx;
	}

	public String getMoSy() {
		return moSy;
	}

	public void setMoSy(String moSy) {
		this.moSy = moSy;
	}

	public String getMoEx() {
		return moEx;
	}

	public void setMoEx(String moEx) {
		this.moEx = moEx;
	}

	public String getMoEy() {
		return moEy;
	}

	public void setMoEy(String moEy) {
		this.moEy = moEy;
	}

	public String getMoColor() {
		return moColor;
	}

	public void setMoColor(String moColor) {
		this.moColor = moColor;
	}

	public String getMo_width() {
		return mo_width;
	}

	public void setMo_width(String mo_width) {
		this.mo_width = mo_width;
	}

	public String getMo_height() {
		return mo_height;
	}

	public void setMo_height(String mo_height) {
		this.mo_height = mo_height;
	}

	public String getMo_rardius() {
		return mo_rardius;
	}

	public void setMo_rardius(String mo_rardius) {
		this.mo_rardius = mo_rardius;
	}

	public String getMo_persons() {
		return mo_persons;
	}

	public void setMo_persons(String mo_persons) {
		this.mo_persons = mo_persons;
	}

	public Modeling(int moProject){
	    this.setMoProject(moProject);
	}

	/**
	 * moEquipStat
	 */
	private boolean moEquipStat = true;
	public boolean isMoEquipStat() {
        return moEquipStat;
    }
    public void setMoEquipStat(boolean moEquipStat) {
        this.moEquipStat = moEquipStat;
    }
	
	
	/**
	 * figuresList
	 */
	private ArrayList<Figures> figuresList;
    public void setFiguresList(ArrayList<Figures> figuresList) {
        this.figuresList = figuresList;
    }
    public void setFiguresList(Figures[] figuresList) {
        this.figuresList = new ArrayList<Figures>(Arrays.asList(figuresList));
        Vector<Figures> figuresVec = new Vector<Figures>(this.figuresList.size());
        figuresVec.addAll(this.figuresList);
        this.setFiguresVector(figuresVec);
    }
    public ArrayList<Figures> getFiguresList() {
        return figuresList;
    }
    
    /**
     * samplesList
     */
	private ArrayList<SampleBean> samplesList;
	public ArrayList<SampleBean> getSamplesList() {
		return samplesList;
	}
	public void setSamplesList(SampleBean[] samplesList) {
        this.samplesList = new ArrayList<SampleBean>(Arrays.asList(samplesList));
        Vector<SampleBean> samplesVec = new Vector<SampleBean>(this.samplesList.size());
        samplesVec.addAll(this.samplesList);
        this.setSamplesVector(samplesVec);
    }
	
	/**
     * figuresVector
     */
	private Vector<Figures> figuresVector;
	public Vector<Figures> getFiguresVector() {
        return figuresVector;
    }
    public void setFiguresVector(Vector<Figures> figuresVector) {
        this.figuresVector = figuresVector;
    }
    
    /**
     * samplesVector
     */
    private Vector<SampleBean> samplesVector;
    public Vector<SampleBean> getSamplesVector() {
    	return samplesVector;
    }
	public void setSamplesVector(Vector<SampleBean> samplesVector) {
	    this.samplesVector = samplesVector;
	}
	
}
