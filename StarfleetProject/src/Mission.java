public class Mission {

    private String name;
    private float riskFactor;
    private int value;
    float successDet;
    boolean missionSuccess;

    Mission()
    {
        name = "Easy Mission";
        riskFactor = 0.8f;
        value = 2000;
    }

    Mission(String _name, float _riskFactor, int _value)
    {
        name = _name;
        riskFactor = _riskFactor;
        value = _value;
    }

    public void Details()
    {
        System.out.println(name+", Risk factor: " + riskFactor + " Reward: " + value);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRiskFactor() {
        return riskFactor;
    }

    public void setRiskFactor(float riskFactor) {
        this.riskFactor = riskFactor;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isMissionSuccess() {
        return missionSuccess;
    }

    public void setMissionSuccess(boolean missionSuccess) {
        this.missionSuccess = missionSuccess;
    }

    public float getSuccessDet() {
        return successDet;
    }

    public void setSuccessDet(float successDet) {
        this.successDet = successDet;
    }
}
