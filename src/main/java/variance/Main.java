package variance;

import java.util.ArrayList;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Dog> dogs = new ArrayList<>(List.of(new Dog(), new Dog()));
    List<Animal> pets = new ArrayList<>(List.of(new Dog(), new Cat()));
    List<Living> livingThings = new ArrayList<>(List.of(new Dog(), new Cactus()));

//    List<Animal> animals1 = dogs; //1
//    List<Animal> animals2 = pets; //2
//    List<Animal> animals3 = livingThings; //3
//    List<? extends Animal> animals4 = dogs; //4
//    List<? extends Animal> animals5 = pets; //5
//    List<? extends Animal> animals6 = livingThings; //6

    List<? extends Animal> animals = dogs;
//    Animal someAnimal = animals.getFirst(); //1
//    Dog someDog = animals.getFirst(); //2
//    animals.add(new Animal()); //3
//    animals.add(new Dog()); //4

    List<Puppy> puppies = new ArrayList<>(List.of(new Puppy(), new Puppy()));
    List<Object> randomObjects = new ArrayList<>(List.of(new Object(), new Object()));

//    List<? super Dog> superDogs1 = dogs; //1
//    List<? super Dog> superDogs2 = pets; //2
//    List<? super Dog> superDogs3 = livingThings; //3
//    List<? super Dog> superDogs4 = puppies; //4
//    List<? super Dog> superDogs5 = randomObjects; //5

    List<? super Dog> superDogs = pets;
//    Dog someDog = superDogs.getFirst(); //1
//    Animal someAnimal = superDogs.getFirst(); //2
//    Object someObject = superDogs.getFirst(); //3
//    superDogs.add(new Dog()); //4
//    superDogs.add(new Animal()); //5
//    superDogs.add(new Puppy()); //6
  }
}

// COVARIANCE
// if S is a subtype of T, then Generic<S> is a subtype of Generic<T>
// Integer extends Number, therefore List<Integer> extends List<Number>

// CONTRAVARIANCE
// if S is a subtype of T, then Generic<S> is a SUPERtype of Generic<S> (and Generic<T> is a SUBtype of Generic<S>)
// Integer extends Number, therefore List<Number> extends List<Integer>

// INVARIANCE
// there is no hierarchy between Generic<S> and Generic<T>
// Integer extends Number, but List<Integer> is neither a subtype nor supertype of List<Number>