package lib.lambdas;

@FunctionalInterface
public interface IEventLambda<T> {

    public void action(T target);
    
}