import java.util.Scanner;

public class ScannerHelper {
	public static boolean created1 = false;
	
	private Scanner sc;
	private boolean broken;
	
	public ScannerHelper() {
		if (!created1) {
			sc = new Scanner (System.in);
			broken = false;
			created1 = true;
		}
		else {
			System.out.println ("You can't create more than one instance");
			broken = true;
		}
	}
	
	public boolean working () {
		return !broken;
	}
}
