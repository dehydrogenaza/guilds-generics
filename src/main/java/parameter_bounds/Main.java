package parameter_bounds;

public class Main {
  public static void main(String[] args) {
//    Crate<Water> crate = new Crate<Water>();
//    crate.load(new Water());
//    crate.load(new Water());

    Crate<Apple> crate = new Crate<Apple>();
    crate.load(new Apple());
    crate.load(new Apple());

    System.out.println(crate.unload(2));
  }
}
