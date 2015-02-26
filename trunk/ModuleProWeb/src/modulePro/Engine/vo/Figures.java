package modulePro.Engine.vo;

import java.math.BigDecimal;
import java.util.ArrayList;

import modulePro.Editor.vo.Project;

public class Figures{
    
    private String      figUid             = "";
    private String      figMoUid           = "";
    private String      figMoType          = "";
    private String      figMoName          = "";
    private String      figFailMode        = "";
    private String      figFailureState    ;
    private BigDecimal  figFailureTime;
    private BigDecimal  figImpFailure;
    private BigDecimal  figMttr;
    private BigDecimal  figImpRepair;
    private String      figRemark1         = "";
    private float       figRandomNum       = 0f;
    private int         figProjectUid      = 0;
    private BigDecimal  figDelivery;
    private BigDecimal  figArt;
    private String      figSeStartDay      = "";
    private int         figFreq            = 0;
    private BigDecimal  figCapLoss;
    private String      figFreqUit         = "";
    private BigDecimal  figFlaring         = new BigDecimal(0);
    private String      figEqRef           = "";
    private int         figDistribution    = 0;
    private BigDecimal  figExpMttf;
    private BigDecimal  figNormExptMttf;
    private BigDecimal  figMinMttf;
    private BigDecimal  figMaxMttf;
    private BigDecimal  figMostMttf;
    private BigDecimal  figWeiCharMttf;
    private BigDecimal  figWeiShapeMttf;
    private BigDecimal  figNormStdMttf;
    private BigDecimal  figWeiDeltime;
    private BigDecimal  figImpRecov;
    private BigDecimal  figRecovFactor     = new BigDecimal(0);
    private int         figRepDistribution = 0;
    private String      figRepModRelia     = "";
    private String      figRepRepeat       = "";
    private int         figRepUpto         = 0;
    
    private BigDecimal  figBreakPoint      = new BigDecimal(0);
    
    private String      figSubsystem      = "";
    
    private String      figTagid          = "";
    
    private ArrayList<FigInform> figInform;
    
    private BigDecimal figFinishRepairTime = new BigDecimal(0);
    
    private BigDecimal figPieceRepairTime = new BigDecimal(0);
    
    private BigDecimal figFinishDeliveryTime = new BigDecimal(0);
    
    private BigDecimal figFinishFlaringTime = new BigDecimal(0);
    
    private boolean    figStates = true;
    

    public Figures(){
    	System.out.println("->"+this.getFigFailureState());
    };
    

    public Figures(Project project){
        setFigProjectUid(project.getProUid());
    }
    

    public Figures(Modeling model){
        this.setFigMoUid(String.valueOf(model.getMoUid()));
    }
    
 
    public Figures(String figUid){
        setFigUid(figUid);
    }
    
    public Figures(int projectUid, String figEqUid, String figUid){
        setFigUid(figUid);
        setFigProjectUid(projectUid);
        setFigMoUid(figEqUid);
    }

    public String getFigUid() {
        return figUid;
    }

    public void setFigUid(String figUid) {
        this.figUid = figUid;
    }

    public String getFigMoUid() {
        return figMoUid;
    }

    public void setFigMoUid(String figMoUid) {
        this.figMoUid = figMoUid;
    }

    public String getFigMoType() {
        return figMoType;
    }

    public void setFigMoType(String figMoType) {
        this.figMoType = figMoType;
    }

    public String getFigMoName() {
        return figMoName;
    }

    public void setFigMoName(String figMoName) {
        this.figMoName = figMoName;
    }

    public String getFigFailMode() {
        return figFailMode;
    }

    public void setFigFailMode(String figFailMode) {
        this.figFailMode = figFailMode;
    }

    public String getFigFailureState() {
        return figFailureState;
    }

    public void setFigFailureState(String figFailureState) {
        //this.figFailureState = figFailureState;
    	this.figFailureState = "1";
    }

    public BigDecimal getFigFailureTime() {
        return figFailureTime;
    }

    public void setFigFailureTime(BigDecimal figFailureTime) {
        this.figFailureTime = figFailureTime;
    }

    public BigDecimal getFigImpFailure() {
        return figImpFailure;
    }

    public void setFigImpFailure(BigDecimal figImpFailure) {
        this.figImpFailure = figImpFailure;
    }

    public BigDecimal getFigMttr() {
        return figMttr;
    }

    public void setFigMttr(BigDecimal figMttr) {
        this.figMttr = figMttr;
    }

    public BigDecimal getFigImpRepair() {
        return figImpRepair;
    }

    public void setFigImpRepair(BigDecimal figImpRepair) {
        this.figImpRepair = figImpRepair;
    }

    public String getFigRemark1() {
        return figRemark1;
    }

    public void setFigRemark1(String figRemark1) {
        this.figRemark1 = figRemark1;
    }

    public float getFigRandomNum() {
        return figRandomNum;
    }

    public void setFigRandomNum(float figRandomNum) {
        this.figRandomNum = figRandomNum;
    }

    public int getFigProjectUid() {
        return figProjectUid;
    }

    public void setFigProjectUid(int figProjectUid) {
        this.figProjectUid = figProjectUid;
    }


    public BigDecimal getFigDelivery() {
        return figDelivery;
    }

    public void setFigDelivery(BigDecimal figDelivery) {
        this.figDelivery = figDelivery;
    }

    public BigDecimal getFigArt() {
        return figArt;
    }

    public void setFigArt(BigDecimal figArt) {
        this.figArt = figArt;
    }

    public String getFigSeStartDay() {
        return figSeStartDay;
    }

    public void setFigSeStartDay(String figSeStartDay) {
        this.figSeStartDay = figSeStartDay;
    }

    public int getFigFreq() {
        return figFreq;
    }

    public void setFigFreq(int figFreq) {
        this.figFreq = figFreq;
    }

    public BigDecimal getFigCapLoss() {
        return figCapLoss;
    }

    public void setFigCapLoss(BigDecimal figCapLoss) {
        this.figCapLoss = figCapLoss;
    }

    public String getFigFreqUit() {
        return figFreqUit;
    }

    public void setFigFreqUit(String figFreqUit) {
        this.figFreqUit = figFreqUit;
    }

    public BigDecimal getFigFlaring() {
        return figFlaring;
    }

    public void setFigFlaring(BigDecimal figFlaring) {
        this.figFlaring = figFlaring;
    }

    public String getFigEqRef() {
        return figEqRef;
    }

    public void setFigEqRef(String figEqRef) {
        this.figEqRef = figEqRef;
    }

    public int getFigDistribution() {
        return figDistribution;
    }

    public void setFigDistribution(int figDistribution) {
        this.figDistribution = figDistribution;
    }

    public BigDecimal getFigExpMttf() {
        return figExpMttf;
    }

    public void setFigExpMttf(BigDecimal figExpMttf) {
        this.figExpMttf = figExpMttf;
    }

    public BigDecimal getFigNormExptMttf() {
        return figNormExptMttf;
    }

    public void setFigNormExptMttf(BigDecimal figNormExptMttf) {
        this.figNormExptMttf = figNormExptMttf;
    }

    public BigDecimal getFigMinMttf() {
        return figMinMttf;
    }

    public void setFigMinMttf(BigDecimal figMinMttf) {
        this.figMinMttf = figMinMttf;
    }

    public BigDecimal getFigMaxMttf() {
        return figMaxMttf;
    }

    public void setFigMaxMttf(BigDecimal figMaxMttf) {
        this.figMaxMttf = figMaxMttf;
    }

    public BigDecimal getFigMostMttf() {
        return figMostMttf;
    }

    public void setFigMostMttf(BigDecimal figMostMttf) {
        this.figMostMttf = figMostMttf;
    }

    public BigDecimal getFigWeiCharMttf() {
        return figWeiCharMttf;
    }

    public void setFigWeiCharMttf(BigDecimal figWeiCharMttf) {
        this.figWeiCharMttf = figWeiCharMttf;
    }

    public BigDecimal getFigWeiShapeMttf() {
        return figWeiShapeMttf;
    }

    public void setFigWeiShapeMttf(BigDecimal figWeiShapeMttf) {
        this.figWeiShapeMttf = figWeiShapeMttf;
    }

    public BigDecimal getFigNormStdMttf() {
        return figNormStdMttf;
    }

    public void setFigNormStdMttf(BigDecimal figNormStdMttf) {
        this.figNormStdMttf = figNormStdMttf;
    }

    public BigDecimal getFigWeiDeltime() {
        return figWeiDeltime;
    }

    public void setFigWeiDeltime(BigDecimal figWeiDeltime) {
        this.figWeiDeltime = figWeiDeltime;
    }

    public BigDecimal getFigImpRecov() {
        return figImpRecov;
    }

    public void setFigImpRecov(BigDecimal figImpRecov) {
        this.figImpRecov = figImpRecov;
    }


    public int getFigRepDistribution() {
        return figRepDistribution;
    }

    public void setFigRepDistribution(int figRepDistribution) {
        this.figRepDistribution = figRepDistribution;
    }

    public BigDecimal getFigRecovFactor() {
        return figRecovFactor;
    }
    
    public void setFigRecovFactor(BigDecimal figRecovFactor) {
        this.figRecovFactor = this.figRecovFactor.multiply(figRecovFactor);
    }

    public void setFigRecovFactor(float figRecovFactor) {
        this.figRecovFactor = this.figRecovFactor.multiply(new BigDecimal(figRecovFactor));
    }
    
    public void setFigRecovFactorIniti(){
        this.figRecovFactor = new BigDecimal(1);
    }

    public String getFigRepModRelia() {
        return figRepModRelia;
    }

    public void setFigRepModRelia(String figRepModRelia) {
        this.figRepModRelia = figRepModRelia;
    }

    public String getFigRepRepeat() {
        return figRepRepeat;
    }

    public void setFigRepRepeat(String figRepRepeat) {
        this.figRepRepeat = figRepRepeat;
    }

    public int getFigRepUpto() {
        return figRepUpto;
    }

    public void setFigRepUpto(int figRepUpto) {
        this.figRepUpto = figRepUpto;
    }

    public BigDecimal getFigBreakPoint() {
        return figBreakPoint;
    }

    public void setFigBreakPoint(float figBreakPoint) {
        this.figBreakPoint = new BigDecimal(figBreakPoint);
    }

    public String getFigSubsystem() {
        return figSubsystem;
    }

    public void setFigSubsystem(String figSubsystem) {
        this.figSubsystem = figSubsystem;
    }

    public String getFigTagid() {
        return figTagid;
    }

    public void setFigTagid(String figTagid) {
        this.figTagid = figTagid;
    }

    public ArrayList<FigInform> getFigInform() {
        return figInform;
    }

    public void setFigInform(ArrayList<FigInform> figInform) {
        this.figInform = figInform;
    }

    /**
     * @return the figFinishRepairTime
     */
    public BigDecimal getFigFinishRepairTime() {
        return figFinishRepairTime;
    }

    /**
     * @param figFinishRepairTime the figFinishRepairTime to set
     */
    public void setFigFinishRepairTime(BigDecimal figFinishRepairTime) {
        this.figFinishRepairTime = figFinishRepairTime;
    }

    /**
     * @return the figPieceRepairTime
     */
    public BigDecimal getFigPieceRepairTime() {
        return figPieceRepairTime;
    }

    /**
     * @param figPieceRepairTime the figPieceRepairTime to set
     */
    public void setFigPieceRepairTime(BigDecimal figPieceRepairTime) {
        this.figPieceRepairTime = figPieceRepairTime;
    }

    /**
     * Accessor the figFinishDeliveryTime
     * @return the figFinishDeliveryTime
     */
    public BigDecimal getFigFinishDeliveryTime() {
        return figFinishDeliveryTime;
    }

    /**
     * Mutator the figFinishDeliveryTime
     * @param figFinishDeliveryTime the figFinishDeliveryTime to set
     */
    public void setFigFinishDeliveryTime(BigDecimal figFinishDeliveryTime) {
        this.figFinishDeliveryTime = figFinishDeliveryTime;
    }

    public BigDecimal getFigFinishFlaringTime() {
		return figFinishFlaringTime;
	}

	public void setFigFinishFlaringTime(BigDecimal figFinishFlaringTime) {
		this.figFinishFlaringTime = figFinishFlaringTime;
	}

	/**
     * Accessor the figStates
     * @return the figStates
     */
    public boolean isFigStates() {
        return figStates;
    }

    /**
     * Mutator the figStates
     * @param figStates the figStates to set
     */
    public void setFigStates(boolean figStates) {
        this.figStates = figStates;
    }
}