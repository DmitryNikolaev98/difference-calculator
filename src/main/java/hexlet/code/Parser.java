package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.IOException;
import java.util.Map;

public class Parser {

    public static Map<String, Object> parserDate(String data, String extension) throws Exception {
        switch (extension) {
            case "json" -> {
                return jsonParse(data);
            }
            case "yaml", "yml" -> {
                return yamlParse(data);
            }
            default -> throw new Exception(extension + "is not supported extension");
        }
    }

    public static Map<String, Object> jsonParse(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(data, new TypeReference<>() {
        });
    }

    public static Map<String, Object> yamlParse(String data) throws IOException {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        return mapper.readValue(data, new TypeReference<>() {
        });
    }

}
