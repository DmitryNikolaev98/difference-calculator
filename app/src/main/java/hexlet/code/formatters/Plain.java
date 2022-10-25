package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Plain {
    public static String getFormated(List<Node> resultListOf) {
        StringBuilder diff = new StringBuilder();

        for (Node pair : resultListOf) {
            String key = pair.getKey();
            Object value1 = stringify(pair.getValue1());
            Object value2 = stringify(pair.getValue2());
            String changesType = pair.getChangesType();

            if (changesType.equals("deleted")) {
                diff.append("Property '")
                        .append(key)
                        .append("' was removed")
                        .append("\n");
            }
            if (changesType.equals("added")) {
                diff.append("Property '")
                        .append(key)
                        .append("' was added with value: ")
                        .append(value2)
                        .append("\n");
            }
            if (changesType.equals("modified")) {
                diff.append("Property '")
                        .append(key)
                        .append("' was updated. ")
                        .append("From ")
                        .append(value1)
                        .append(" to ")
                        .append(value2)
                        .append("\n");
            }
        }

        diff.setLength(diff.length() - 1);

        return diff.toString();
    }

    private static Object stringify(Object value) {
        if (value instanceof String) {
            return "'" + value + "'";
        }
        if (value instanceof Collection || value instanceof Map) {
            return "[complex value]";
        }

        return Objects.toString(value);
    }
}

