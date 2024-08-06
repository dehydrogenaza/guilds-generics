package type_erasure;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

//How to parse a string into an object?
//1. create an "empty" instance
//2. read fields from string
//3. set fields on the instance

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

  public static <T> T readProper(String rawData, Class<T> type) {
    try {
      T instance = type.getDeclaredConstructor()
          .newInstance();
      rawData.lines()
          .map(line -> line.split(",", 2))
          .forEach(parts -> setField(instance, parts[0], parts[1]));

      return instance;
    } catch (ReflectiveOperationException e) {
      System.out.println(":-(");
      throw new RuntimeException(e);
    }
  }

  public static <T> T readByTypeReference(String rawData, TypeReference<T> typeReference) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.readValue(rawData, typeReference);
  }

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

    Person person = StringParser.read(rawData);
//    var actualPerson = StringParser.readProper(rawData, Person.class);
//    Person alsoActualPerson = StringParser.readByTypeReference(rawData, new TypeReference<>() {});

    System.out.println(person);
  }
}

