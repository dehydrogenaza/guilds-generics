package variance;

import java.util.ArrayList;
import java.util.List;

public class VarianceExplanation {
  public static void main(String[] args) {
    //COVARIANCE
    List<Animal> animals = new ArrayList<Animal>();

    List<Living> livingThings = new ArrayList<Living>();
    livingThings.add(new Cactus());


    // ---


    //CONTRAVARIANCE
    List<Animal> animals2 = new ArrayList<Animal>();
    animals2.add(new Cat());

    List<Dog> dogs = new ArrayList<Dog>();
    Dog doggo = dogs.getFirst();
  }
}
