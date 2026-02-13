package d5.LambdaExp;

@FunctionalInterface
public interface Operation<T> {

    T operate(T x, T y);
}
