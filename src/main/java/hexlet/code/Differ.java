package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Comparator;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Differ {
    public static String generate(String file1, String file2) throws Exception {

        Map<String, Object> fileJson1 = getData(file1);
        Map<String, Object> fileJson2 = getData(file2);

        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new HashSet<>(fileJson1.keySet());
        keys.addAll(fileJson2.keySet());

        for (String key: keys) {
            if (!fileJson1.containsKey(key)) {
                result.add(Map.of("key", key, "value", fileJson2.get(key), "res", "+"));
            } else if (!fileJson2.containsKey(key)) {
                result.add(Map.of("key", key, "value", fileJson1.get(key), "res", "-"));
            } else if (fileJson2.get(key).equals(fileJson1.get(key))) {
                result.add(Map.of("key", key, "value", fileJson1.get(key), "res", " "));
            } else {
                result.add(Map.of("key", key, "value", fileJson1.get(key), "res", "-"));
                result.add(Map.of("key", key, "value", fileJson2.get(key), "res", "+"));
            }
        }
        result = result.stream()
                .sorted(Comparator.comparing(item -> item.get("key").toString()))
                .collect(Collectors.toList());

        StringBuilder  resultStr = new StringBuilder("{\n");

        for (Map<String, Object> item : result) {
            resultStr.append(item.get("res"))
                    .append(" ")
                    .append(item.get("key"))
                    .append(": ")
                    .append(item.get("value"))
                    .append("\n");
        }
        resultStr.append("}");

        return resultStr.toString();
    }
   /* private static Map<String, Object> getJsonFile(String filePath) throws IOException {
        String jsonString = Files.readString(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, new TypeReference<>() {
        });
    }*/

    public static Map<String, Object> getData(String filePath) throws Exception {
        String path = generatePathToFile(filePath);
        String extension = getFileExtension(filePath);
        return Parser.parserDate(path, extension);
    }

    public static String getFileExtension(String filePath) {
        int index = filePath.lastIndexOf('.');
        return index > 0 ? filePath.substring(index + 1) : "";
    }


    public static String generatePathToFile(String fileName) throws IOException {
        return Files.readString(Paths.get(fileName).toAbsolutePath().normalize());
    }

}
