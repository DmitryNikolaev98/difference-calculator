package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.nio.file.Path;
import java.util.concurrent.Callable;
import static java.nio.file.Files.readString;

import static hexlet.code.Differ.generate;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> {

    @Parameters(index = "0", description = "path to first file")
    private Path  filepath1;
    @Parameters(index = "1", description = "path to second file")
    private Path  filepath2;
    @Option(names = {"-f", "--format"}, description = "output format [default: stylish]")
    private String format;
    @Override
    public String call() throws Exception {
        return "call is working";
    }
    public static void main(String... args) throws Exception {
        App app = new App();
        int exitCode = new CommandLine(app).execute(args);
        System.exit(exitCode);

        String string1 = readString(app.filepath1);
        System.out.println(string1);
        String string2 = readString(app.filepath2);
        System.out.println(string2);
        String diff = Differ.generate(string1, string2);
        System.out.println(diff);
    }
}
