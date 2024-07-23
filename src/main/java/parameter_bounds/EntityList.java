package parameter_bounds;

import java.util.ArrayList;

public class EntityList<T> extends ArrayList<T> {
  T findById(int id) {
    for (T entity : this) {
      if (id == ((WithId) entity).getId()) { //not ideal!
        return entity;
      }
    }
    return null;
  }


//  at COMPILE time, EntityList<Person>::findById becomes equivalent to:
//  Person findById(int id) {
//    for (Person entity : this) {
//      if (id == ((WithId) entity).getId()) {
//        return entity;
//      }
//    }
//    return null;
//  }


  public static void main(String[] args) {
    EntityList<Person> people = new EntityList<>();
    people.add(new Person(1, "Alice"));
    people.add(new Person(2, "Bob"));
    people.add(new Person(3, "Charlie"));

    Person person = people.findById(2);
    System.out.println(person.getName());


    //uh oh
    EntityList<String> messages = new EntityList<>();
    messages.add("Hello");
    messages.add("World");

    String msg = messages.findById(1);
    System.out.println(msg);
  }
}
