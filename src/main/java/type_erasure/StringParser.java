package type_erasure;
import java.util.List;

public class StringParser {
  public static <T> T read(String rawData) {
    try {
      T instance = new T(); //what is the type of instance here?
      rawData.lines()
          .map(line -> line.split(",", 2))
          .forEach(parts -> setField(instance, parts[0], parts[1]));

      return instance;
    } catch (ReflectiveOperationException e) {
      System.out.println(":-(");
      throw new RuntimeException(e);
    }
  }

//  public static <T> T readProper(String rawData, Class<T> type) {
//    try {
//      T instance = type.getDeclaredConstructor()
//          .newInstance();
//      rawData.lines()
//          .map(line -> line.split(",", 2))
//          .forEach(parts -> setField(instance, parts[0], parts[1]));
//
//      return instance;
//    } catch (ReflectiveOperationException e) {
//      System.out.println(":-(");
//      throw new RuntimeException(e);
//    }
//  }

  private static <T> void setField(T instance, String field, String value) {
    var setter = "set" + field.substring(0, 1)
        .toUpperCase() + field.substring(1);
    try {
      instance.getClass()
          .getDeclaredMethod(setter, String.class)
          .invoke(instance, value);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }

  public static void main(String[] args) {
    var rawData = "name,John Doe\ncountry,USA";

    var person = StringParser.read(rawData);
//    var actualPerson = StringParser.readProper(rawData, Person.class);

    System.out.println(person);
  }
}

