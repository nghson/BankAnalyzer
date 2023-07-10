package bankanalyzer;

@FunctionalInterface
public interface Summarizer {
    double summarize(double res, BankTransaction transaction);
}
