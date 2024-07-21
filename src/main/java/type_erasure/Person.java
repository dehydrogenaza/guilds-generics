package type_erasure;

public class Person {
  private String name;
  private String country;

  public void setName(String name) {
    this.name = name;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public String toString() {
    return "Person" +
        "\nname: " + name +
        "\ncountry: " + country;
  }
}
