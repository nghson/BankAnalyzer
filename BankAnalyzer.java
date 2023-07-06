package bankanalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class BankAnalyzer {
	private static final String DATA_DIR = "./bankanalyzer/";

	public static void main(final String... args) throws IOException {
		final Parser parser = new Parser();
		final Path path = Paths.get(DATA_DIR + args[0]);
		final List<String> lines = Files.readAllLines(path);
		
		final List<BankTransaction> bankTransactions
				= parser.parseLines(lines);

		System.out.println("Transaction total: " + getTotal(bankTransactions));
		System.out.println("Transaction in Jan: " + getMonth(bankTransactions, Month.JANUARY));
	}

	public static double getTotal(final List<BankTransaction> bankTransactions) {
		double total = 0d;
		for (final BankTransaction bankTransaction: bankTransactions) {
			total += bankTransaction.getAmount();
		}
		return total;
	}

	public static List<BankTransaction> getMonth(final List<BankTransaction> bankTransactions, final Month month) {
		final List<BankTransaction> result = new ArrayList<>();
		for (final BankTransaction bankTransaction: bankTransactions) {
			if (bankTransaction.getDate().getMonth() == month) {
				result.add(bankTransaction);
			}
		}
		return result;
	}
}
