import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class Main {
  public static void main(String[] args) {
    List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
    list.forEach((element) -> System.out.println(element));

    int result = calculator((a, b) -> a + b, 5, 2);
    var result2 = calculator((a, b) -> a / b, 20, 2);

    var coords = Arrays.asList(
        new double[]{47.2160, -95.2348},
        new double[]{29.1566, -89.2495},
        new double[]{35.1556, -90.0659}
    );

    coords.forEach((arr) -> System.out.println(Arrays.toString(arr)));

    coords.forEach(arr -> processPoint(arr[0], arr[1], (lat, lon) -> System.out.printf("lat: %.3f, long: %.3f\n", lat, lon)));

    list.removeIf(s -> s.equalsIgnoreCase("bravo"));
    list.forEach((el) -> System.out.println(el));
  }

  public static <T> T calculator(Operation<T> myFunction, T value1, T value2) {
    T result = myFunction.operate(value1, value2);
    System.out.println("Result of operation: " + result);
    return result;
  }

  public static <T> void processPoint(T p1, T p2, BiConsumer<T, T> consumer) {
    consumer.accept(p1, p2);
  }
}
