package modulePro.Engine.vo;

import java.math.BigDecimal;

public class SampleBean{
	private int moBr;
	private int moPre;
	private int moSelf;
	private String      figUid          = "";
    private String      figMoUid           = "";
    private String      figMoType          = "";
    private String      figMoName          = "";
    private String      figFailMode        = "";
    private String      figFailureState    = "";
    private float  figFailureTime;
    private BigDecimal  figImpFailure;
    private float  figMttr;
    private BigDecimal  figImpRepair;
    private String      figRemark1         = "";
    private float       figRandomNum       = 0f;
    private int         figProjectUid      ;
    private BigDecimal  figDelivery;
    private BigDecimal  figArt;
    private String      figSeStartDay      = "";
    private int         figFreq            = 0;
    private BigDecimal  figCapLoss;
    private String      figFreqUit         = "";
    private BigDecimal  figFlaring         = new BigDecimal(0);
    private String      figEqRef           = "";
    private int         figDistribution    = 0;
    private float figExpMttf;
    private float  figNormExptMttf;
    private float figMinMttf;
    private float figMaxMttf;
    private float figMostMttf;
    private BigDecimal  figWeiCharMttf;
    private BigDecimal  figWeiShapeMttf;
    private float  figNormStdMttf;
    private BigDecimal  figWeiDeltime;
    private float  figImpRecov;
    private BigDecimal  figRecovFactor     = new BigDecimal(0);
    private int         figRepDistribution = 0;
    private String      figRepModRelia     = "";
    private String      figRepRepeat       = "";
    private int         figRepUpto         = 0;
    private String      figTagid          = "";
    private String figSubsystem;
    private int 		figFreqStepResult	=0;
    
	public int getFigFreqStepResult() {
		return figFreqStepResult;
	}
	public void setFigFreqStepResult(int figFreqStepResult) {
		this.figFreqStepResult = figFreqStepResult;
	}
	public String getFigTagid() {
		return figTagid;
	}
	public void setFigTagid(String figTagid) {
		this.figTagid = figTagid;
	}
	public int getMoBr() {
		return moBr;
	}
	public void setMoBr(int moBr) {
		this.moBr = moBr;
	}
	public int getMoPre() {
		return moPre;
	}
	public void setMoPre(int moPre) {
		this.moPre = moPre;
	}
	public int getMoSelf() {
		return moSelf;
	}
	public void setMoSelf(int moSelf) {
		this.moSelf = moSelf;
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
		this.figFailureState = figFailureState;
	}
	public float getFigFailureTime() {
		return figFailureTime;
	}
	public void setFigFailureTime(float figFailureTime) {
		this.figFailureTime = figFailureTime;
	}
	public BigDecimal getFigImpFailure() {
		return figImpFailure;
	}
	public void setFigImpFailure(BigDecimal figImpFailure) {
		this.figImpFailure = figImpFailure;
	}
	public float getFigMttr() {
		return figMttr;
	}
	public void setFigMttr(float figMttr) {
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
	public float getFigExpMttf() {
		return figExpMttf;
	}
	public void setFigExpMttf(float figExpMttf) {
		this.figExpMttf = figExpMttf;
	}
	public float getFigNormExptMttf() {
		return figNormExptMttf;
	}
	public void setFigNormExptMttf(float figNormExptMttf) {
		this.figNormExptMttf = figNormExptMttf;
	}
	public float getFigMinMttf() {
		return figMinMttf;
	}
	public void setFigMinMttf(float figMinMttf) {
		this.figMinMttf = figMinMttf;
	}
	public float getFigMaxMttf() {
		return figMaxMttf;
	}
	public void setFigMaxMttf(float figMaxMttf) {
		this.figMaxMttf = figMaxMttf;
	}
	public float getFigMostMttf() {
		return figMostMttf;
	}
	public void setFigMostMttf(float figMostMttf) {
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
	public float getFigNormStdMttf() {
		return figNormStdMttf;
	}
	public void setFigNormStdMttf(float figNormStdMttf) {
		this.figNormStdMttf = figNormStdMttf;
	}
	public BigDecimal getFigWeiDeltime() {
		return figWeiDeltime;
	}
	public void setFigWeiDeltime(BigDecimal figWeiDeltime) {
		this.figWeiDeltime = figWeiDeltime;
	}
	public float getFigImpRecov() {
		return figImpRecov;
	}
	public void setFigImpRecov(float figImpRecov) {
		this.figImpRecov = figImpRecov;
	}
	public BigDecimal getFigRecovFactor() {
		return figRecovFactor;
	}
	public void setFigRecovFactor(BigDecimal figRecovFactor) {
		this.figRecovFactor = figRecovFactor;
	}
	public int getFigRepDistribution() {
		return figRepDistribution;
	}
	public void setFigRepDistribution(int figRepDistribution) {
		this.figRepDistribution = figRepDistribution;
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
	public String getFigSubsystem() {
		return figSubsystem;
	}
	public void setFigSubsystem(String figSubsystem) {
		this.figSubsystem = figSubsystem;
	}
    
    
}
