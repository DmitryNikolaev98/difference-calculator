package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
public class Differ {
    public static String generate(String file1, String file2) throws Exception {

        Map<String, Object> fileJson1 = getJsonFile(file1);
        Map<String, Object> fileJson2 = getJsonFile(file2);

        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new HashSet<>(fileJson1.keySet());
        keys.addAll(fileJson2.keySet());

        for (String key: keys) {
            if (!fileJson1.containsKey(key)) {
                result.add(Map.of("key", key, "value", fileJson2.get(key), "res", "+"));
            } else {
                if (!fileJson2.containsKey(key)) {
                    result.add(Map.of("key", key, "value", fileJson1.get(key), "res", "-"));
                } else {
                    if (fileJson2.get(key).equals(fileJson1.get(key))) {
                        result.add(Map.of("key", key, "value", fileJson1.get(key), "res", " "));
                    } else {
                        result.add(Map.of("key", key, "value", fileJson1.get(key), "res", "-"));
                        result.add(Map.of("key", key, "value", fileJson2.get(key), "res", "+"));
                    }
                }
            }
        }
        result = result.stream()
                .sorted(Comparator.comparing(item -> item.get("key").toString()))
                .collect(Collectors.toList());

        StringBuilder  resultStr = new StringBuilder("{\n");

        for (Map<String, Object> item : result) {
            resultStr.append(item.get("res")).append(" ").append(item.get("key")).append(": ").append(item.get("value")).append("\n");
        }
        resultStr.append("}");

        return resultStr.toString();
    }
    private static Map<String, Object> getJsonFile(String filePath) throws IOException {
        String jsonString = Files.readString(Paths.get(filePath));
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonString, new TypeReference<>(){});
    }

}
