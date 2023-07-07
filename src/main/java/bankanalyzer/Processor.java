package bankanalyzer;

import java.time.Month;
import java.util.List;

public class Processor {
    private final List<BankTransaction> bankTransactions;

    public Processor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double getTotal() {
        double total = 0d;
        for (final BankTransaction bankTransaction: bankTransactions) {
            total += bankTransaction.getAmount();
        }
        return total;
    }

    public double getMonthTotal(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    public double getCategoryTotal(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }
}