package lib.internalApi;

import lib.lambdas.IEventLambda;

public class Action<T> implements IAction {

    private T target;

    private IEventLambda<T> event;

    public Action(IEventLambda<T> e, T t) {
        event = e; target = t;
    }

    @Override
    public void apply() {
        event.action(target);
    }
}