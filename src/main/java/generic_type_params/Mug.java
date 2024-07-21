package generic_type_params;

public class Mug<T> {
  private final T liquid;

  public Mug(T liquid) {
    this.liquid = liquid;
  }

//  public T drink() {
//    return liquid;
//  }

  public <T> void pour(T liquid) {
    //
  }

//  public class Properties<T> {
//    private final T material;
//
//    public Properties(T material) {
//      this.material = material;
//    }
//  }
}
