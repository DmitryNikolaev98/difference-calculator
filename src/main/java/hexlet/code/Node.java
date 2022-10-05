package hexlet.code;

public class Node {
    private final String style;
    private final String key;
    private final Object value1;
    private final Object value2;

    public Node(String changesStyle, String key, Object value1, Object value2) {
        this.style = changesStyle;
        this.key = key;
        this.value1 = value1;
        this.value2 = value2;
    }
    public final String getChangesType() {
        return style;
    }

    public final String getKey() {
        return key;
    }

    public final Object getValue1() {
        return value1;
    }

    public final Object getValue2() {
        return value2;
    }
}