package bankanalyzer;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Processor {
    private final List<BankTransaction> bankTransactions;

    public Processor(final List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double summarizeTransactions(final Summarizer summarizer) {
        double result = 0;

        for (final BankTransaction transaction: bankTransactions) {
            result = summarizer.summarize(result, transaction);
        }

        return result;
    }

    public double getMonthTotal(final Month month) {
        return summarizeTransactions((total, transaction) ->
                transaction.getDate().getMonth() == month ? total + transaction.getAmount() : total);
    }

    public double getCategoryTotal(final String category) {
        return summarizeTransactions((total, transaction) ->
                transaction.getDescription().equals(category) ? total + transaction.getAmount() : total);
    }

    public double getTotal() {
        return summarizeTransactions((total, transaction) -> total + transaction.getAmount());
    }

    public List<BankTransaction> findTransactionsGEQ(final int amount) {
        return findTransactions(transaction -> transaction.getAmount() >= amount);
    }

    public List<BankTransaction> findTransactions(final BankTransactionFilter filter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction transaction: bankTransactions) {
            if (filter.test(transaction)) {
                result.add(transaction);
            }
        }
        return result;
    }
}