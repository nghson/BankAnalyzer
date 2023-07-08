package bankanalyzer;

import java.io.IOException;
import java.nio.file.*;
import java.time.Month;
import java.util.List;


public class BankAnalyzer {
	public void analyze(final String filename, final Parser parser) throws IOException {
		final Path path = Paths.get(filename);
		final List<String> lines = Files.readAllLines(path);

		final List<BankTransaction> bankTransactions
				= parser.parseLines(lines);
		final Processor processor = new Processor(bankTransactions);
		summary(processor);
	}

	private static void summary(Processor processor) {
		System.out.println("Transaction total: " + processor.getTotal());
		System.out.println("Transaction in January: " + processor.getMonthTotal(Month.JANUARY));
		System.out.println("Total salary: " + processor.getCategoryTotal("Salary"));
	}
}
