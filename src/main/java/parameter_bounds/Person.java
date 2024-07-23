package parameter_bounds;

public class Person implements WithId {
  private final int id;
  private final String name;

  public Person(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  @Override
  public int getId() {
    return id;
  }
}
