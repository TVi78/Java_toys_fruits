
public class Toy {
  int id;
  String name;
  private int count;
  private float freq;

  public Toy(int id, String name, int count, float freq) {
    this.id = id;
    this.name = name;
    this.count = count;
    this.freq = freq;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }

  public float getFreq() {
    return freq;
  }

  public void setFreq(int id, float freq) {
    this.freq = freq;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "id: " + this.id + ", name: " + this.name;
  }

}
