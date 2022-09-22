package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.nio.file.Paths;

class DifferTest {

    private static final String PATH1 = "src/test/resources/file1.json";
    private static final String PATH2 = "src/test/resources/file2.json";

    private static String absolutePath1;
    private static String absolutePath2;
    private final String expectedTest =
                    "{\n"
                    + "- follow: false\n"
                    + "  host: hexlet.io\n"
                    + "- proxy: 123.234.53.22\n"
                    + "- timeout: 50\n"
                    + "+ timeout: 20\n"
                    + "+ verbose: true\n"
                    + "}";

    @BeforeAll
    static void preparing() {
        absolutePath1 = Paths.get(PATH1).toFile().getAbsolutePath();
        absolutePath2 = Paths.get(PATH2).toFile().getAbsolutePath();
    }

    @Test
    void runApp() throws Exception {
        String result = Differ.generate(absolutePath1, absolutePath2);
        assertEquals(expectedTest, result);

    }
}