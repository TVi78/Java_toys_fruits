package mapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class FileSaver {
  private final Mapper mapper;

  public FileSaver(Mapper mapper) {
      this.mapper = mapper;
  }

  public void save(String path, Map<Integer, List> data) {
      try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
          writer.write(mapper.map(data));
          writer.flush();
      } catch (IOException e) {
          e.printStackTrace();
      }
      System.out.println("Data saved...");
  }
}