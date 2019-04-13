package lib.lambdas;

public interface IEventLambda<T> {

    public void action(T target);
    
}