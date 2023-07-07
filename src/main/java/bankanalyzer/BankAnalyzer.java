package bankanalyzer;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;


public class BankAnalyzer {
	private static final String DATA_DIR = "src/main/resources/data.csv";
	private static final Parser parser = new Parser();

	public static void main(final String... args) throws IOException {
		final Path path = Paths.get(DATA_DIR);
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
