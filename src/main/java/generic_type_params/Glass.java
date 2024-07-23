package generic_type_params;

public class Glass<T> {
  private final T liquid;

  public Glass(T liquid) {
    this.liquid = liquid;
  }

  public T drink() {
    return liquid;
  }

  public <T> void pour(T liquid) {
    //
  }
}
