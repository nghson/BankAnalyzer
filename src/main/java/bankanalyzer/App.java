package bankanalyzer;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        final String filename = args.length > 0 ? args[0] : "src/main/resources/data.csv";
        final BankAnalyzer analyzer = new BankAnalyzer();
        final Parser parser = new ParserCSV();
        analyzer.analyze(filename, parser);
    }
}