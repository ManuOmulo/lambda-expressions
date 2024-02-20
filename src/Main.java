import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(List.of("alpha", "beta", "charlie", "delta"));
    list.forEach((element) -> System.out.println(element));

    int result = calculator((a, b) -> a + b, 5, 2);
    var result2 = calculator((a, b) -> a / b, 20, 2);
  }

  public static <T> T calculator(Operation<T> myFunction, T value1, T value2) {
    T result = myFunction.operate(value1, value2);
    System.out.println("Result of operation: " + result);
    return result;
  }
}
