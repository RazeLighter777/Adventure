package lib.lambdas;

@FunctionalInterface
public interface IEventLambda<T> {

    /**
     * execute an action on a target
     * @param target The target the action is executed upon
     */
    public void action(T target);
    
}