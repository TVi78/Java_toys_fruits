// Ваш файл `input.txt` содержит множество слов, разделенных пробелами.
// 1. Осуществить подсчет слов: Напишите программу, которая подсчитывает количество слов в файле `input.txt`.
// 2. Найти самое длинное слово: Создайте программу, которая находит самое длинное слово в файле.
// 3. Вычислить частоту слов: Напишите программу, которая анализирует, сколько раз каждое слово встречается в файле.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main
 */
public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    int sum = 0;
    String maxLength = "";
    Map<String, Integer> map = fillMap("input.txt");
    for (int value : map.values()) {
      sum += value;
    }
    for (String value : map.keySet()) {
      if (value.length() > maxLength.length())
        maxLength = value;
    }
    System.out.println("Общее количество слов в файле: " + sum);
    System.out.println("Самое длинное слово: " + maxLength);

    map.forEach((key, value) -> System.out.println(key + ":" + value));
  }

  private static Map<String, Integer> fillMap(String path) throws FileNotFoundException {
    Map<String, Integer> map = new HashMap<>();
    File data = new File(path);
    Scanner scanner = new Scanner(data);
    ArrayList<String> list = new ArrayList<>();
    while (scanner.hasNextLine()) {
      String str = scanner.nextLine();
      String[] arr = str.trim().split(" ");
      list.addAll(Arrays.asList(arr));
    }
    for (String key : list) {
      if (map.containsKey(key)) {
        int value = map.get(key);
        value++;
        map.put(key, value);
      } else {
        if (key != "")
          map.put(key, 1);
      }
    }
    return map;
  }
}
