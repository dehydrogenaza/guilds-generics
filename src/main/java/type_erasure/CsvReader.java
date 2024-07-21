package type_erasure;

public class CsvReader {
  public static <T> T read(String csv) {
    try {
      //what is the type of instance here?
      T instance = new T();
      csv.lines()
          .map(line -> line.split(",", 2))
          .forEach(parts -> setField(instance, parts[0], parts[1]));

      return instance;
    } catch (ReflectiveOperationException e) {
      System.out.println(":-(");
      throw new RuntimeException(e);
    }
  }

//  public static <T> T read(String csv, Class<T> type) {
//    try {
//      T instance = type.getDeclaredConstructor().newInstance();
//      csv.lines()
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
    var setter = "set" + field.substring(0, 1).toUpperCase() + field.substring(1);
    try {
      instance.getClass().getDeclaredMethod(setter, String.class).invoke(instance, value);
    } catch (ReflectiveOperationException e) {
      throw new RuntimeException(e);
    }
  }
}

