package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Stylish;

import java.util.List;

public class Formatter {
    public final String getDiff(List<Node> allDifferences, String format) throws JsonProcessingException {
        return switch (format) {
            case ("stylish") -> Stylish.getFormated(allDifferences);
            default -> "Unexpected format: " + format;
        };
    }
}
