package modulePro.Engine.vo;

/**
 * ?๋ฎฌ๋ ?ด? ??ด์ง??? ๊ธฐ๊ณ?น ?์น๋ค? hazard rate, random number๋ฅ?
 * ???๊ธ? ??ด ??ฑ? ?ด??ค ???ค.
 * 
 * @author Choi Jin Wook(A.K.A Brian Choi @ Ordobill Office) / choijinwook84@gmail.com
 *
 */
public class FigInform {
    private int figUid    = 0;
    private float hazardRate = 0f;
    private float randomNum = 0f;

    public int getFigUid() {
        return figUid;
    }
    public void setFigUid(int figUid) {
        this.figUid = figUid;
    }
    
    public float getHazardRate() {
        return hazardRate;
    }
    public void setHazardRate(float hazardRate) {
        this.hazardRate = hazardRate;
    }
    public float getRandomNum() {
        return randomNum;
    }
    public void setRandomNum(float randomNum) {
        this.randomNum = randomNum;
    }
}
