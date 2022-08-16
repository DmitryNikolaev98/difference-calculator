package hexlet.code;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Differ {
    public static String generate(String path1, String path2) throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1
                = mapper.readValue(path1, new TypeReference<Map<String, Object>>(){});
        Map<String, Object> map2
                = mapper.readValue(path2, new TypeReference<Map<String, Object>>(){});
        return "call is working";
    }
}
