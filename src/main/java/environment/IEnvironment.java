package environment;

import java.io.Serializable;

public interface IEnvironment extends Serializable {

    public static final long serialVersionUID = 1;

    /**
     *
     * @return A value from zero to one where 0 is maximum friction and 1 is no friction
     */
    public double getSlipperiness();

    /**
     *
     * @return The temperature in fahrenheit
     */
    public double getTemperature();

    /**
     *
     * @return A number from 0-1 describing how easy it is to see in the environment
     */
    public double getVisibility();

    /**
     *
     * @return A number from 0-1 indicating the amount of cover the environment provides
     */
    public double getCover();
}