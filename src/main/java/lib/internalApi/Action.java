package lib.internalApi;

import java.util.ArrayList;
import java.util.Arrays;

import lib.lambdas.IEventLambda;

public final class Action<T> implements IAction {

    private ArrayList<T> target;

    private IEventLambda<T> event;

    public Action(IEventLambda<T> e, T t) {
        target = new ArrayList<T>();
        event = e; 
        target.set(0, t);
    }

    public Action(IEventLambda<T> e, T[] t) {
        target = new ArrayList<T>(Arrays.asList(t));
        event = e;
    }

    @Override
    public void apply() {
        for (T object : target) {
            event.action(object);
        }
    }
}