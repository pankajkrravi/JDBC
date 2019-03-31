public class BankFactory {
	static ICard getCash(String type) {
		if (type.equalsIgnoreCase("ICICI")) {
			return new ICICI();
		} else if (type.equalsIgnoreCase("SBI")) {
			return new SBI();
		} else {
			System.out.println("Bank nort found");
		}
		return null;
	}
}
