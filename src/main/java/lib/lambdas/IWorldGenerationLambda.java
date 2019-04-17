package lib.lambdas;

import java.util.ArrayList;

import environment.IWorld;
import environment.Room;
import lib.internalApi.Environment.Point;

@FunctionalInterface
public interface IWorldGenerationLambda {
    Room generateRoom(IWorld w, Point p);
}