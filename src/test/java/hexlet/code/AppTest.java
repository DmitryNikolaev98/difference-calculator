package hexlet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

class AppTest {
    private static final String JSON_FILE_1 = makeFullPathForTestFile("file1.json");
    private static final String JSON_FILE_2 = makeFullPathForTestFile("file2.json");

    private static final String YML_FILE_1 = makeFullPathForTestFile("file1.yml");
    private static final String YML_FILE_2 = makeFullPathForTestFile("file2.yml");

    private final String stylishFormat = "stylish";
    private final String plainFormat = "plain";

    private static String makeFullPathForTestFile(String fileName) {
        return "src/test/resources/" + fileName;
    }

    private static String fullPathForFixtureFile(String fileName) {
        return "src/test/resources/formatters/" + fileName;
    }

    @Test
    void defaultFormat() throws Exception {
        String actualJsons = Differ.generate(JSON_FILE_1, JSON_FILE_2);
        String actualYmls = Differ.generate(YML_FILE_1, YML_FILE_2);

        String stylishPath = fullPathForFixtureFile(stylishFormat);
        String expected = Files.readString(Paths.get(stylishPath)).replaceAll("\\r", "");

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void filesStylish() throws Exception {
        String actualJsons = Differ.differGenerate(JSON_FILE_1, JSON_FILE_2, stylishFormat);
        String actualYmls = Differ.differGenerate(YML_FILE_1, YML_FILE_2, stylishFormat);

        String stylishPath = fullPathForFixtureFile(stylishFormat);
        String expected = Files.readString(Paths.get(stylishPath)).replaceAll("\\r", "");

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

    @Test
    void filesPlain() throws Exception {
        String actualJsons = Differ.differGenerate(JSON_FILE_1, JSON_FILE_2, plainFormat);
        String actualYmls = Differ.differGenerate(YML_FILE_1, YML_FILE_2, plainFormat);

        String plainPath = fullPathForFixtureFile(plainFormat);
        String expected = Files.readString(Paths.get(plainPath)).replaceAll("\\r", "");

        Assertions.assertEquals(expected, actualJsons);
        Assertions.assertEquals(expected, actualYmls);
    }

}
