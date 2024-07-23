package variance;
import java.util.ArrayList;
import java.util.List;

//example hierarchy:
// Animal implements Living
// Cactus implements Living
// Cat extends Animal
// Dog extends Animal


// INVARIANCE
// there is no hierarchy between Generic<S> and Generic<T>
// Integer extends Number, but List<Integer> is neither a subtype nor supertype of List<Number>
// indicated by the absence of wildcards (default)

// UNKNOWN TYPE
// <?> indicates an unknown (opaque) type

// COVARIANCE
// if S is a subtype of T, then Generic<S> is a subtype of Generic<T>
// Integer extends Number, therefore List<Integer> extends List<Number>
// indicated by the wildcard <? extends T>

// CONTRAVARIANCE
// if S is a subtype of T, then Generic<S> is a SUPERtype of Generic<S> (and Generic<T> is a SUBtype of Generic<S>)
// Integer extends Number, therefore List<Number> extends List<Integer>
// indicated by the wildcard <? super T>



public class Wildcards {
  public static void main(String[] args) {
    List<Dog> dogs = new ArrayList<>(List.of(new Dog(), new Dog()));
    List<Animal> pets = new ArrayList<>(List.of(new Dog(), new Cat()));
    List<Living> livingThings = new ArrayList<>(List.of(new Dog(), new Cactus()));

//    List<Animal> animals1 = dogs; //1 List<Dog>
//    List<Animal> animals2 = pets; //2 List<Animal>
//    List<Animal> animals3 = livingThings; //3 List<Living>
//    List<? extends Animal> animals4 = dogs; //4 List<Dog>
//    List<? extends Animal> animals5 = pets; //5 List<Animal>
//    List<? extends Animal> animals6 = livingThings; //6 List<Living>

    List<? extends Animal> animals = dogs;
//    Animal someAnimal = animals.getFirst(); //1
//    Dog someDog = animals.getFirst(); //2
//    animals.add(new Animal()); //3
//    animals.add(new Dog()); //4

    List<Object> randomObjects = new ArrayList<>(List.of(new Object(), new Object()));
//    List<? super Animal> superAnimals1 = pets; //1 List<Animal>
//    List<? super Animal> superAnimals2 = livingThings; //2 List<Living>
//    List<? super Animal> superAnimals3 = dogs; //3 List<Dog>
//    List<? super Animal> superAnimals5 = randomObjects; //4 List<Object>

    List<? super Animal> superAnimals = pets;
//    Animal anAnimal = superAnimals.getFirst(); //1
//    Living aLivingThing = superAnimals.getFirst(); //2
//    Object anObject = superAnimals.getFirst(); //3
//    superAnimals.add(new Animal()); //4
//    superAnimals.add(new Object()); //5
//    superAnimals.add(new Dog()); //6
  }
}
