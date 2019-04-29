package lib.internalApi.stats;

import java.util.ArrayList;

public class FormativeStat implements IStat {

    public static final long serialVersionUID = 1;

    public ArrayList<IStat> baseStats;

    public String name;

    public FormativeStat(ArrayList<IStat> baseStats, String name) {
        this.baseStats = baseStats;
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getBoostValue() {
        double boost = 1.0;
        for (IStat i : baseStats) {
            boost*=i.getBoostValue();
        }
        return boost;
    }

    @Override
    public int getValue() {
        return (int) Math.round(getBoostValue() * baseStats.stream().mapToInt(n -> n.getValue()).sum());
    }
}
