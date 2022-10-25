package hexlet.code;

public class Node {
    private final String style;
    private final String key;
    private final Object value1;
    private final Object value2;

    public Node(String changesStyle, String newKey, Object newValue1, Object newValue2) {
        this.style = changesStyle;
        this.key = newKey;
        this.value1 = newValue1;
        this.value2 = newValue2;
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
