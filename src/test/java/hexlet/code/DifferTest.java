package hexlet.code;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import java.nio.file.Paths;

class DifferTest {

    private static final String FILE_JSON1 = "src/test/resources/file1.json";
    private static final String FILE_JSON2  = "src/test/resources/file2.json";

    private static final String FILE_YAML1  = "src/test/resources/file1.json";
    private static final String FILE_YAML2 = "src/test/resources/file2.json";

    private static String absolutePathJson1;
    private static String absolutePathJson2;
    private static String absolutePathYaml1;
    private static String absolutePathYaml2;
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
        absolutePathJson1 = Paths.get(FILE_JSON1).toFile().getAbsolutePath();
        absolutePathJson2 = Paths.get(FILE_JSON2).toFile().getAbsolutePath();
        absolutePathYaml1 = Paths.get(FILE_YAML1).toFile().getAbsolutePath();
        absolutePathYaml2 = Paths.get(FILE_YAML2).toFile().getAbsolutePath();
    }

    @Test
    void runTestJson() throws Exception {
        String result = Differ.generate(absolutePathJson1, absolutePathJson2);
        assertEquals(expectedTest, result);
    }

    @Test
    void runTestYaml() throws Exception {
        String result = Differ.generate(absolutePathYaml1, absolutePathYaml2);
        assertEquals(expectedTest, result);
    }
}
