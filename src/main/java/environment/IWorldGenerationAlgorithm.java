package environment;

import lib.internalApi.environment.Point;

public interface IWorldGenerationAlgorithm {

    /**
     *
     * @return The name of the algorithm
     */
    String getName();

    /**
     * @return The description of the algorithm
     */
    String getDescription();

    /**
     * Generates rooms starting from a given point. May create multiple or one rooms, it depends on the algorithm's implementation.
     * @param w The world interface
     * @param p The point
     * @return The room that was generated.
     */
    Room generateAtPoint(IWorld w, Point p);
}