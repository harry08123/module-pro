package modulePro.Engine;

import java.util.ArrayList;
import java.util.HashMap;

import modulePro.Engine.vo.SampleBean;
import modulePro.Engine.vo.Sampleform;
import modulePro.Engine.vo.SimulationFields;
import modulePro.Editor.vo.Project;

public class SampleEngine {
	
	int saControl = 0;
	
	public Sampleform engineCore(Project project,ArrayList<SampleBean> figList,HashMap<String, SimulationFields[]> simulationArr){
		
		Sampleform sampleform = new Sampleform();
		sampleform.setLifeTime(project.getProLifeTime());
		sampleform.setIteration(project.getProIterNum());
		sampleform.setTd((float)project.getProTd());
		
		float[][] resultArr = null;
		float[] totavaArr = null;
		ArrayList<int[][]> breakList = new ArrayList<int[][]>();
		
		float[] iterationArr = new float [sampleform.getIteration()];
		String[][] stepAve = new String [2][figList.size()];
		String[] stepFigName = new String [figList.size()];
		sampleform.setIterationArr(new float [sampleform.getIteration()]);
		sampleform.setYeartotRoof((int)sampleform.getTd()*24);
		sampleform.setTotRoof((int)(sampleform.getYeartotRoof())*sampleform.getLifeTime());
		
		sampleform.setFailState("flaring");
		for (int k=0;k<sampleform.getIteration();k++) {
			int[][] brakeArr = new int[3][figList.size()];
			for (int i=0;i<brakeArr[0].length;i++) {
				//brakeArr[1][i] = figList.get(i).getFigUid();
			}
			resultArr = new float[figList.size()+1][(int)sampleform.getTotRoof()];
			totavaArr = new float[sampleform.getLifeTime()];
			sampleform.setYearAvailability(0f);
			sampleform.setRepearState(true);
			
			for (int i=0;i<figList.size();i++) {
				saControl = 1;
				sampleform.setStep(0f);
				sampleform.setPresent(0f);
				sampleform.setMaxMttf(figList.get(i).getFigMaxMttf()*8760f);
				sampleform.setMinMttf(figList.get(i).getFigMinMttf()*8760f);
				sampleform.setMostMttf(figList.get(i).getFigMostMttf()*8760f);
				
				
				for (int s=0;s<sampleform.getTotRoof();s++){
					if (sampleform.getPresent() <= s) {
						this.computeHazardRate(sampleform,figList.get(i));
						
						if (sampleform.isGeneralState()) {
							sampleform.setRepearState(true);
							sampleform.setPresent(sampleform.getPresent()+24);
						} else {
							brakeArr[0][i] = brakeArr[0][i] + 1;
							if (figList.get(i).getFigMoType().equals("se")) {
								sampleform.setRepearState(false);
								sampleform.setPresent(sampleform.getPresent()+figList.get(i).getFigMttr());
							} else if (sampleform.getFailState() == "flaring" && figList.get(i).getFigFlaring().floatValue() > 1) {
								sampleform.setRepearState(true);
								sampleform.setPresent(s+figList.get(i).getFigFlaring().floatValue());
								sampleform.setFailState("mttr");
							} else if (sampleform.getFailState() == "mttr" && figList.get(i).getFigFlaring().floatValue() > 1) {
								sampleform.setRepearState(false);
								sampleform.setImpRepair(figList.get(i).getFigMttr());
								sampleform.setImpFailure(figList.get(i).getFigDelivery().floatValue());
								sampleform.setPresent(sampleform.getPresent()+sampleform.getImpFailure()+sampleform.getImpRepair());
								sampleform.setImpRepair(s+sampleform.getImpRepair());
								sampleform.setFailState("flaring");
							} else {
								if (Integer.parseInt(figList.get(i).getFigFailureState()) == 1) {
									sampleform.setRepearState(false);
									sampleform.setImpRepair(figList.get(i).getFigMttr());
									sampleform.setImpFailure(figList.get(i).getFigDelivery().floatValue());
									sampleform.setPresent(sampleform.getPresent()+sampleform.getImpFailure()+sampleform.getImpRepair());
									sampleform.setImpRepair(s+sampleform.getImpRepair());
								} else if (Integer.parseInt(figList.get(i).getFigFailureState())> 1){
									sampleform.setRepearState(true);
								}
							}
							sampleform.setBreakpoint(sampleform.getPresent()); 
						}
					}
					if (sampleform.isRepearState()) {
						sampleform.setAvailability(100f);
					} else {
						if (sampleform.getImpRepair()>s) { //delivery
							sampleform.setAvailability(100f - (figList.get(i).getFigImpFailure().floatValue()*100f));	
						} else { //mttr
							sampleform.setAvailability(100f - (figList.get(i).getFigImpRepair().floatValue()*100f));	
						}
					}
					resultArr[i][s] = sampleform.getAvailability();
					
					sampleform.setStep(sampleform.getAvailability()+sampleform.getStep());
				} //end for s
				
				stepAve[0][i] = figList.get(i).getFigMoName();
				float val = (1-((sampleform.getTotRoof()-sampleform.getStep())/sampleform.getTotRoof()));
				if (k == 0) {
					stepAve[1][i] = Float.toString(val);
				} else if(k == sampleform.getIteration()-1) { 
					stepAve[1][i] = Float.toString((val+Float.valueOf(stepAve[1][i]).floatValue())/sampleform.getIteration());
				} else {
					stepAve[1][i] = Float.toString(val+Float.valueOf(stepAve[1][i]).floatValue());
				}
				
				sampleform.setBreakpoint(0);
			} //end for i
			
			for (int s=0;s<sampleform.getTotRoof();s++) {
				for (int i=0;i<figList.size();i++) {
					
		 			if (sampleform.getAvailability() > resultArr[i][s] || i == 0) {
						sampleform.setAvailability(resultArr[i][s]);
					}
				}
				resultArr[figList.size()][s] = sampleform.getAvailability();
				sampleform.setYearAvailability(sampleform.getYearAvailability() + sampleform.getAvailability());
				if (((s+1)%sampleform.getYeartotRoof()) == 0) {
					int arrNum = (int) ((s+1)/sampleform.getYeartotRoof())-1;
					sampleform.setYearAvailability(sampleform.getYearAvailability()/100f);
					totavaArr[arrNum] = sampleform.getYearAvailability();
					sampleform.setYearAvailability(0f);;
				}
				sampleform.setAvailability(0f);
			}
			
			for (int i=0;i<totavaArr.length;i++) {
				sampleform.setAvailability(sampleform.getAvailability() + totavaArr[i]);
			}
			float stdAva = (1-((sampleform.getTotRoof()-sampleform.getAvailability())/sampleform.getTotRoof()));
			iterationArr[k] = stdAva;
			sampleform.setAvailabilityAll(sampleform.getAvailabilityAll() + stdAva);
		} //end for k
		
		sampleform.setStepAve(stepAve);
		sampleform.setStepFigName(stepFigName);
		sampleform.setBrakeArr(breakList);
		sampleform.setResultArr(resultArr);
		sampleform.setIterationArr(iterationArr);
		sampleform.setYeartotRoof(sampleform.getYeartotRoof());
		sampleform.setTotRoof((int)sampleform.getTotRoof());
		sampleform.setTotAvailability((sampleform.getAvailabilityAll()/sampleform.getIteration())*100);
		sampleform.setFmcont(figList.size()+1);
		
		return sampleform;
	}
	
	
	private boolean computeHazardRate(Sampleform sampleform,SampleBean samplebean) {
		sampleform.setHazardRate(0f);
		if (samplebean.getFigDistribution() == 1) { //Exponential
			sampleform.setHazardRate(1f/(samplebean.getFigExpMttf()*sampleform.getTd()));
		} else if (samplebean.getFigDistribution() == 3) {//Rectangular
			if (sampleform.getPresent() < sampleform.getMinMttf()) {
				sampleform.setHazardRate(0f);
			} else if (sampleform.getMinMttf() <= sampleform.getPresent() && sampleform.getPresent() <= sampleform.getMaxMttf()) {	
				sampleform.setHazardRate(1f/(((sampleform.getMaxMttf()-sampleform.getPresent())/8760f)*365f));
	        } else {
	        	if (sampleform.getPresent() > sampleform.getMaxMttf()) {
	        		sampleform.setMinMttf((samplebean.getFigMinMttf()*8760f)+sampleform.getPresent());
	        		sampleform.setMaxMttf((samplebean.getFigMaxMttf()*8760f)+sampleform.getPresent());
	        	}
	        }
			
		} else if (samplebean.getFigDistribution() == 2){//Normal
			double presentLife = 0;
			
	        if(sampleform.getBreakpoint() > 0f){
	        	presentLife = sampleform.getPresent() - sampleform.getBreakpoint();
	        }else{
	        	presentLife = sampleform.getPresent();
	        }
	        double normalHazardRate = this.numericalCalculation((presentLife/8760d), samplebean.getFigNormExptMttf(), samplebean.getFigNormStdMttf());
	        normalHazardRate = normalHazardRate/sampleform.getTd();
	        sampleform.setHazardRate(normalHazardRate);
		
		} else if (samplebean.getFigDistribution() == 4) {//Triangular
			if (sampleform.getPresent() < sampleform.getMinMttf()) {
				sampleform.setHazardRate(0f);
			} else if(sampleform.getMinMttf() <= sampleform.getPresent() && sampleform.getPresent() <= sampleform.getMostMttf()){
	            float val1 = 2f*(sampleform.getPresent() - sampleform.getMinMttf());
	        	float val2 = sampleform.getMaxMttf() - sampleform.getMinMttf();
	        	float val3 = sampleform.getMostMttf() - sampleform.getMinMttf();
	        	float val4 = (float)Math.pow(sampleform.getPresent() - sampleform.getMinMttf(),2);
	        	float val5 = (((val2*val3)-val4)/8760f)*365f;
	        	sampleform.setHazardRate(val1/val5);
	        } else if (sampleform.getMostMttf() <= sampleform.getPresent() && sampleform.getPresent() <= sampleform.getMaxMttf()){
	            //sampleform.setHazardRate(2f/(((sampleform.getMaxMttf()-sampleform.getPresent())/8760f)*365f)); 2014.10.25 蹂�寃�
	        	sampleform.setHazardRate(1f/(((sampleform.getMaxMttf()-sampleform.getPresent())/8760f)*365f));
	        } else {
	        	if (sampleform.getPresent() > sampleform.getMaxMttf()) {
	        		sampleform.setMinMttf((samplebean.getFigMinMttf()*8760f)+sampleform.getPresent());
	        		sampleform.setMaxMttf((samplebean.getFigMaxMttf()*8760f)+sampleform.getPresent());
	        		sampleform.setMostMttf((samplebean.getFigMostMttf()*8760f)+sampleform.getPresent());
	        	}
	        }
		} else if (samplebean.getFigDistribution() == 5) {//5:Weibull
			double presentLife = 0;
			
	        if(sampleform.getBreakpoint() > 0f){
	        	presentLife = sampleform.getPresent() - sampleform.getBreakpoint();
	        }else{
	        	presentLife = sampleform.getPresent();
	        }
			double num1 = (samplebean.getFigWeiShapeMttf().doubleValue()/ samplebean.getFigWeiCharMttf().doubleValue());
			double num2 = Math.pow(((presentLife/8760f)/ samplebean.getFigWeiCharMttf().doubleValue()), samplebean.getFigWeiShapeMttf().doubleValue() -1f);
			System.out.println(num2 + " = " + "Math.pow(("+ presentLife + "/8760f)/" + samplebean.getFigWeiCharMttf().doubleValue() + "), " + samplebean.getFigWeiShapeMttf().doubleValue() + "-1f)");
			System.out.println((num1*num2)/365f + " = (" +num1 + "*" + num2 + ")/365f ");
			sampleform.setHazardRate((num1*num2)/365f);
		} else if (samplebean.getFigDistribution() == 6) {//6:Weibull Time Delay
			float lifePresent = sampleform.getPresent()-sampleform.getBreakpoint();
		    sampleform.setTimeDelay(sampleform.getTimeDelay()+sampleform.getBreakpoint());
			
			double num1 = (samplebean.getFigWeiShapeMttf().doubleValue()/ samplebean.getFigWeiCharMttf().doubleValue());
			double num2 = Math.pow(((lifePresent/8760f)/ samplebean.getFigWeiCharMttf().doubleValue()), samplebean.getFigWeiShapeMttf().doubleValue() -1f);
			sampleform.setHazardRate((num1*num2)/365f);
		       
		} else {
			if ((samplebean.getFigFreq()*saControl)*8760<sampleform.getPresent()) {
				saControl++;
				sampleform.setGeneralState(false);
				return sampleform.isGeneralState();
			} else {
				sampleform.setGeneralState(true);
				return sampleform.isGeneralState();
			}
		}
		if (sampleform.getHazardRate() < this.getRandomNumbers(0,samplebean.getFigDistribution())) {
			sampleform.setGeneralState(true);
		} else {
			sampleform.setGeneralState(false);
			if (samplebean.getFigDistribution() == 2) {
			} else if (samplebean.getFigDistribution() == 3) {
	        		sampleform.setMinMttf((samplebean.getFigMinMttf()*8760f)+sampleform.getPresent());
	        		sampleform.setMaxMttf((samplebean.getFigMaxMttf()*8760f)+sampleform.getPresent());			
			} else if (samplebean.getFigDistribution() == 4) {
        		sampleform.setMinMttf((samplebean.getFigMinMttf()*8760f)+sampleform.getPresent());
        		sampleform.setMaxMttf((samplebean.getFigMaxMttf()*8760f)+sampleform.getPresent());
        		sampleform.setMostMttf((samplebean.getFigMostMttf()*8760f)+sampleform.getPresent());				
			} else if (samplebean.getFigDistribution() == 5 || samplebean.getFigDistribution() == 6) {
			}
		}

		return sampleform.isGeneralState();
	}
	
	private double numericalCalculation(double x, double mean, double std_dv){
    	double result 	= 0;
    	double valPDF 	= 0;
    	double valCDF 	= 0;
    	double mu 		= mean;
    	double sigma 	= std_dv;
    	double t 		= x;
    	double c0 		= 0.231641900000;
    	double c1 		= 0.319381530000;
    	double c2 		= -0.356563782000;
    	double c3 		= 1.781477937000;
    	double c4 		= -1.821255978000;
    	double c5 		= 1.330274429000;
    	double z 		= (t-mu)/sigma; 
    	double Iroot2pi = 1/Math.sqrt(2*Math.PI); 
    	double ta		= 1/(1+c0*Math.abs(z));
    	double TA		= Iroot2pi * Math.exp(-0.5*z*z) * (c1*ta+c2*ta*ta+c3*ta*ta*ta+c4*ta*ta*ta*ta+c5*ta*ta*ta*ta*ta);
    	if (z>0) {
    		valCDF = 1-TA;
    	} else if (z<=0) {
    		valCDF = TA;
    	}
    	valPDF = Iroot2pi/sigma * Math.exp(-0.5*Math.pow(z, 2));
    	if (z>0) {
    		result = valPDF/(1-valCDF);
    	} else if (z<=0) {
    		result = valPDF/(1-valCDF);
    	}
    	return result;
    }
	
	private double getRandomNumbers(int n,int division){
		return (double)Math.random();
    }
	
}
