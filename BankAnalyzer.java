public class BankAnalyzer {
	private static final String DATA = "./";

	public static void main(final String... args) throws IOException {
		final Path path = Paths.get(DATA + args[0]);
		final List<String> lines = Files.readAllLines(path);
		double total = 0d;
		for (final String line: lines) {
			final String[] columns = line.split(",");
			final double amount = Double.parseDouble(columns[1]);
			total += amount;
		}

		System.out.println("Transaction total: " + total);
	}
}
