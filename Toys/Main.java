import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mapper.FileSaver;
import mapper.Mapper;
import mapper.json.JsonMapper;

public class Main {

  public static void main(String[] args) {
    Toy cat = new Toy(1, "cat", 3, 20f);
    Toy dog = new Toy(2, "dog", 10, 60f);
    Toy bird = new Toy(3, "bird", 7, 5f);
    List toysList = new LinkedList<>();
    for (int i = 0; i < cat.getCount(); i++) {
      toysList.add(cat);
    }
    for (int i = 0; i < dog.getCount(); i++) {
      toysList.add(dog);
    }
    for (int i = 0; i < bird.getCount(); i++) {
      toysList.add(bird);
    }

    changeWeight(dog, 50);

    Toy rabbit = addToy(4, "rabbit", 15, 25f);

    for (int i = 0; i < rabbit.getCount(); i++) {
      toysList.add(rabbit);
    }

    List<Toy> toysPrize = prizeToy(toysList, 6);
    // for (Toy i : toysPrize) {
    // System.out.println(i.toString());
    // }

    Map<Integer, List> map = new HashMap<>();

    for (int i = 0; i < 5; i++) {
      map = getToy(toysPrize.get(i), map);
    }
  }

  private static Toy addToy(int id, String name, int count, float freq) {
    return new Toy(id, name, count, freq);
  }

  private static void changeWeight(Toy toy, float neWeight) {
    toy.setFreq(toy.getId(), neWeight);
  }

  private static List<Toy> prizeToy(List<Toy> list, int count) {
    Collections.shuffle(list);
    int sum;
    int i = 0;
    List prizeList = new ArrayList<Toy>();
    for (Toy toy : list) {
      if (i < count) {
        sum = Collections.frequency(prizeList, toy);
        if (sum < toy.getFreq() / 100 * count && sum <= toy.getCount()) {
          prizeList.add(toy);
          i++;
        }
      }
    }
    return prizeList;
  }

  private static Map getToy(Toy toy, Map map) {
    List list = new ArrayList<>();
    list.add(toy.getName());
    list.add(" count: " + (toy.getCount() - 1));
    list.add(" freq: " + toy.getFreq());
    map.put(toy.getId(), list);
    Mapper jsonMapper = new JsonMapper();
    FileSaver jsonSaver = new FileSaver(jsonMapper);
    jsonSaver.save("toys.json", map);
    return map;
  }
}
