import java.util.Scanner;

public class TetsBank {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter bank name");
		String type = sc.nextLine();
		ICard ca = BankFactory.getCash(type);
		{
			if (ca != null)
			{
				ca.swipe();
			}
		}
	}
}
