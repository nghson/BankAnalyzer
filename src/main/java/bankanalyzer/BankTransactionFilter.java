package bankanalyzer;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction transaction);
}
