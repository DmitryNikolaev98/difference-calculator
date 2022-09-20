package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.nio.file.Paths;

class DifferTest {

    private static final String FILE1 = "src/test/resources/file1.json";
    private static final String FILE2 = "src/test/resources/file2.json";

    private static String filePath1;
    private static String filePath2;
    private final String expectedTest =
            "{\n"
                    + "- follow: false\n"
                    + "  host: hexlet.io\n"
                    + "- proxy: 123.234.53.22\n"
                    + "- timeout: 50\n"
                    + "+ timeout: 20\n"
                    + "+ verbose: true\n"
                    + "}\n";

    @BeforeAll
    static void preparing() {
        filePath1 = Paths.get(FILE1).toFile().getAbsolutePath();
        filePath2 = Paths.get(FILE2).toFile().getAbsolutePath();
    }

    @Test
    void runApp() throws Exception {
        String result = Differ.generate(filePath1, filePath2);
        assertEquals(expectedTest, result);

    }


}