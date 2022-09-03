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

        Map<String, Object> data1 = getJsonFile(file1);
        Map<String, Object> data2 = getJsonFile(file2);

        List<Map<String, Object>> result = new ArrayList<>();

        Set<String> keys = new HashSet<>(data1.keySet());
        keys.addAll(data2.keySet());

        for (String key: keys) {
            if (!data1.containsKey(key)) {
                result.add(Map.of("key", key, "value", data2.get(key), "res", "+"));
            } else {
                if (!data2.containsKey(key)) {
                    result.add(Map.of("key", key, "value", data1.get(key), "res", "-"));
                } else {
                    if (data2.get(key).equals(data1.get(key))) {
                        result.add(Map.of("key", key, "value", data1.get(key), "res", " "));
                    } else {
                        result.add(Map.of("key", key, "value", data1.get(key), "res", "-"));
                        result.add(Map.of("key", key, "value", data2.get(key), "res", "+"));
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
