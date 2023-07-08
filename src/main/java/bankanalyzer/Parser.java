package bankanalyzer;

import java.util.List;

public interface Parser {
    BankTransaction parseLine(String line);
    List<BankTransaction> parseLines(List<String> lines);
}