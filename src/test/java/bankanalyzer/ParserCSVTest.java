package bankanalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class ParserCSVTest {
    private final Parser parser = new ParserCSV();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "10-10-2010,100,Lidl";
        final BankTransaction result = parser.parseLine(line);

        final BankTransaction expected
                = new BankTransaction(LocalDate.of(2010, Month.OCTOBER, 10), 100, "Lidl");
        final double e = 0.0d;

        Assertions.assertEquals(expected.getDate(), result.getDate());
        Assertions.assertEquals(expected.getAmount(), result.getAmount(), e);
        Assertions.assertEquals(expected.getDescription(), result.getDescription());
    }
}