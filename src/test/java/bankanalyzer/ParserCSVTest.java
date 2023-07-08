package bankanalyzer;

import org.junit.Assert;
import org.junit.Test;

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

        Assert.assertEquals(expected.getDate(), result.getDate());
        Assert.assertEquals(expected.getAmount(), result.getAmount(), e);
        Assert.assertEquals(expected.getDescription(), result.getDescription());
    }
}