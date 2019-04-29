package lib.internalApi.stats;

import java.io.Serializable;
import java.util.ArrayList;

public interface IStat extends Serializable {

    public static final long serialVersionUID = 1;

    /**
     *
     * @return The name of the stat
     */
    String getName();

    /**
     *
     * @return The boost value of the stat
     */
    double getBoostValue();

    /**
     *
     * @return The value of the stat.
     */
    int getValue();


}
