package lib.internalApi.stats;

public class BaseStat implements IStat {

    public static final long serialVersionUID = 1;

    private int level;

    private double boostValue;

    private String name;

    public BaseStat(int level, double boostValue, String name) {
        this.level = level;
        this.boostValue = boostValue;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBoostValue() {
        return boostValue;
    }

    @Override
    public int getValue() {
        return level;
    }
}
