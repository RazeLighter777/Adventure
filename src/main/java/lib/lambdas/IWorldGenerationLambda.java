package lib.lambdas;

import java.util.ArrayList;

import environment.IWorld;
import environment.Room;

@FunctionalInterface
public interface IWorldGenerationLambda {
    void generateWorld(IWorld w, ArrayList<ArrayList<Room>> rooms);
}