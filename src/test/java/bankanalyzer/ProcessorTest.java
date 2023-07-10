package bankanalyzer;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ProcessorTest {
    private List<BankTransaction> createList() {
        List<BankTransaction> transactions = new ArrayList<>();
        transactions.add(new BankTransaction(LocalDate.of(2000, Month.APRIL, 1), 10, "Lidl"));
        transactions.add(new BankTransaction(LocalDate.of(2000, Month.APRIL, 5), 10, "Lidl"));
        transactions.add(new BankTransaction(LocalDate.of(2000, Month.APRIL, 25), -30, "K"));
        transactions.add(new BankTransaction(LocalDate.of(2000, Month.MAY, 10), 100, "S"));
        return transactions;
    }

    private final Processor processor = new Processor(createList());

    @Test
    public void shouldGetCorrectMonthTotal() throws Exception {
        final double result = processor.getMonthTotal(Month.APRIL);
        final double expected = -10;
        final double e = 0.0d;

        Assertions.assertEquals(result, expected, e);
    }

    @Test
    public void shouldGetCorrectCategoryTotal() throws Exception {
        final double result = processor.getCategoryTotal("Lidl");
        final double expected = 20;
        final double e = 0.0d;

        Assertions.assertEquals(result, expected, e);
    }

    @Test
    public void shouldGetCorrectTotal() throws Exception {
        final double result = processor.getTotal();
        final double expected = 90;
        final double e = 0.0d;

        Assertions.assertEquals(result, expected, e);
    }

    @Test
    public void shouldGetAllGEQ() throws Exception {
        final List<BankTransaction> result = processor.findTransactionsGEQ(10);

        Assertions.assertEquals(result.size(), 3);
    }
}