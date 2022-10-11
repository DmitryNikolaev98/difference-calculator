package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public final String getDiff(List<Node> allDifferences, String format) throws JsonProcessingException {
        return switch (format) {
            case ("stylish") -> Stylish.getFormated(allDifferences);
            case ("plain") -> Plain.getFormated(allDifferences);
            case ("json") -> Json.getFormated(allDifferences);
            default -> "Unexpected format: " + format;
        };
    }
}
