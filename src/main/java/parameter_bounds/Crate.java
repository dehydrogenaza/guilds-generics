package parameter_bounds;

import java.util.ArrayList;
import java.util.List;

public class Crate<T> {
  private List<T> content = new ArrayList<>();

  public void load(T content) {
    this.content.add(content);
  }

  public void load(List<T> contents) {
    this.content.addAll(contents);
  }

  public List<T> unload(int amount) {
    if (amount > content.size()) {
      throw new IllegalArgumentException("Not enough content to unload");
    }

    List<T> unloaded = content.subList(0, amount);
    content = content.subList(amount, content.size());
    return unloaded;
  }
}
