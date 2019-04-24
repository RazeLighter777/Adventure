package lib.internalApi.environment;

import environment.IEnvironment;

public class Environment implements IEnvironment {

    public static final long serialVersionUID = 1;

    protected double slip;

    protected double temp;

    protected double visibility;

    protected double cover;

    /**
     *
     * @param s The slipperiness of the environment
     * @param t The temperature of the environment
     * @param v The visibility of the environment
     * @param c The cover of the environment
     */
    public Environment(double s, double t, double v, double c) {
        slip = s;
        temp = t;
        visibility = v;
        cover = c;
    }

    @Override
    public double getSlipperiness() {
        return slip;
    }

    @Override
    public double getTemperature() {
        return temp;
    }

    @Override
    public double getVisibility() {
        return visibility;
    }

    @Override
    public double getCover() {
        return cover;
    }
}
