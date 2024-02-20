import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

  record Person(String firstName, String lastName) {
    @Override
    public String toString() {
      return firstName + " " + lastName;
    }
  }

  public static void main(String[] args) {
    List<Person> people = new ArrayList<>();
    people.add(new Person("Emmanuel", "Omulo"));
    people.add(new Person("Patrick", "Mahomes"));
    people.add(new Person("Travis", "Kelce"));
    people.add(new Person("Taylor", "Swift"));

//    Using anonymous class
    var comparatorLastName = new Comparator<Person>() {
      @Override
      public int compare(Person p1, Person p2) {
        return p1.lastName.compareTo(p2.lastName);
      }
    };

    people.sort(comparatorLastName);
    System.out.println(people);

//    Using Lambda Expression
    people.sort((p1, p2) -> p1.firstName.compareTo(p2.firstName));
    System.out.println(people);
  }
}
