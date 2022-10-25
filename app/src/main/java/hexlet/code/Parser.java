
package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.util.Map;

public class Parser {
    public static Map<String, Object> generate(String content, String contentType) throws Exception {
        ObjectMapper mapper = switch (contentType) {
            case "yml", "yaml" -> new ObjectMapper(new YAMLFactory());
            case "json" -> new ObjectMapper();
            default -> throw new Exception("Unexpected format: " + contentType);
        };

        return mapper.readValue(content, new TypeReference<>() { });
    }
}
