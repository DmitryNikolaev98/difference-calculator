package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import java.util.concurrent.Callable;

@Command(name = "gendiff", mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")
class App implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("call is working");
        return "call is working";
    }
    public static void main(String... args) {
        int exitCode = new CommandLine(new App()).execute(args);
        System.exit(exitCode);
    }
}
