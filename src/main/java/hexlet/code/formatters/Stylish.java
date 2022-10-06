package hexlet.code.formatters;

import hexlet.code.Node;

import java.util.List;

public class Stylish {

    public static String getFormated(List<Node> resultListOf) {
        StringBuilder diff = new StringBuilder().append("{\n");

        for (Node pair : resultListOf) {
            String key = pair.getKey();
            Object value1 = pair.getValue1();
            Object value2 = pair.getValue2();
            String changesType = pair.getChangesType();

            if (changesType.equals("result1")) {
                diff.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");
            }
            if (changesType.equals("result2")) {
                diff.append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");
            }
            if (changesType.equals("result3")) {
                diff.append("    ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n");
            }
            if (changesType.equals("result4")) {
                diff.append("  - ")
                        .append(key)
                        .append(": ")
                        .append(value1)
                        .append("\n")

                        .append("  + ")
                        .append(key)
                        .append(": ")
                        .append(value2)
                        .append("\n");
            }
        }

        diff.append("}");
        return diff.toString();
    }
}
