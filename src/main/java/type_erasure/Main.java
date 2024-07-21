package type_erasure;

public class Main {
  public static void main(String[] args) {
    var csv = "name,John Doe\ncountry,USA";

//    var person = CsvReader.read(csv);
    var person = CsvReader.read(csv, Person.class);

    System.out.println(person);
  }
}
