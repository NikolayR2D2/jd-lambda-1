import java.util.function.*;

public class Calculator {
    static Supplier<Calculator> instance = Calculator::new;

    public Calculator() {
        this.instance = instance;
    }

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;

    // BinaryOperator<Integer> devide = (x, y) -> x / y;
    // Ошибка при делении на ноль
    BinaryOperator<Integer> divide = (x, y) -> {
        if (y == 0)
            throw new java.lang.ArithmeticException("Деление на ноль запрещено");
        return x / y;
    };

    UnaryOperator<Integer> pow = x -> x * x;

    // UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;
    // Отрицательный ноль
    UnaryOperator<Integer> abs = x -> x < 0 ? -x : x;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;
}
