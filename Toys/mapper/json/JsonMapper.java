package mapper.json;

import java.util.List;
import java.util.Map;
import mapper.Mapper;

public class JsonMapper implements Mapper {

  @Override
  public String map(Map<Integer, List> data) {
    StringBuilder builder = new StringBuilder("{");

    for (Map.Entry<Integer, List> entry: data.entrySet()) {
            builder.append("\"")
                    .append(entry.getKey())
                    .append("\": \"")
                    .append(entry.getValue())
                    .append("\", ");
        }

        builder.delete(builder.length() -2, builder.length());
        builder.append("}");

        return builder.toString();
    
  }

}
