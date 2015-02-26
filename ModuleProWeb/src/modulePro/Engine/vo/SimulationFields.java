package modulePro.Engine.vo;

import java.util.ArrayList;

/**
 * ?ãúÎÆ¨Î†à?ù¥?Öò?ùò Í≤∞Í≥ºÎ•? ?ã¥?äî Í∞ùÏ≤¥?ûÖ?ãà?ã§.
 */
public class SimulationFields{
    
    private int   iterationStep     = 0;
    private float repairTime        = 0f;
    private float availabilityValue = 0f;
    private float latestMttf        = 0f;
    private float latestHard        = 0f;
    private float latestRandom      = 0f;
    
    private ArrayList<Figures> figureList;
    
    private Float[] timeOfSimulation;
    
    public int getIterationStep() {
        return iterationStep;
    }

    public void setIterationStep(int iterationStep) {
        this.iterationStep = iterationStep;
    }

    public float getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(float repairTime) {
        this.repairTime = repairTime;
    }

    public float getAvailabilityValue() {
        return availabilityValue;
    }

    public void setAvailabilityValue(float availabilityValue) {
        this.availabilityValue = availabilityValue;
    }

    public float getLatestMttf() {
        return latestMttf;
    }

    public void setLatestMttf(float latestMttf) {
        this.latestMttf = latestMttf;
    }

    public float getLatestHard() {
        return latestHard;
    }

    public void setLatestHard(float latestHard) {
        this.latestHard = latestHard;
    }

    public float getLatestRandom() {
        return latestRandom;
    }

    public void setLatestRandom(float latestRandom) {
        this.latestRandom = latestRandom;
    }

    public Float[] getTimeOfSimulation() {
        return timeOfSimulation;
    }

    public void setTimeOfSimulation(Float[] timeOfSimulation) {
        this.timeOfSimulation = timeOfSimulation;
    }

    public ArrayList<Figures> getFigureList() {
        return figureList;
    }

    public void setFigureList(ArrayList<Figures> figureList) {
        this.figureList = figureList;
    }
    
}
