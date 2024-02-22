import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

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

    System.out.println("--------------------");
    list.removeIf(s -> s.equalsIgnoreCase("bravo"));
    list.forEach((el) -> System.out.println(el));

    System.out.println("--------------------");
    list.replaceAll((s) -> s.charAt(0) + " - " + s.toUpperCase());
    list.forEach(el -> System.out.println(el));

    System.out.println("--------------------");
    String[] names = {"Anne", "Bob", "Caroline", "David", "Edward", "Fred"};
    String[] randomList = randomSelectedValues(12, names, () -> new Random().nextInt(0, names.length));
    System.out.println(Arrays.toString(randomList));
  }

  public static <T> T calculator(Operation<T> myFunction, T value1, T value2) {
    T result = myFunction.operate(value1, value2);
    System.out.println("Result of operation: " + result);
    return result;
  }

  public static <T> void processPoint(T p1, T p2, BiConsumer<T, T> consumer) {
    consumer.accept(p1, p2);
  }

  public static String[] randomSelectedValues(int count, String[] values, Supplier<Integer> s) {
    String[] selectedValues = new String[count];

    for (int i = 0; i < count; i++) {
      selectedValues[i] = values[s.get()];
    }

    return selectedValues;
  }
}
