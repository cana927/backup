
public class ScannerHelperTester {
	public static void main (String[]args) {
		ScannerHelper sh = new ScannerHelper();
		ScannerHelper sh2 = new ScannerHelper();
		if (sh.working()) {
			System.out.println("First is working!");
		}
		else { 
			System.out.println ("First is not working!");
		}
		if (sh2.working()) {
			System.out.println("Second is working!");
		}
		else {
			System.out.println ("Second is not working!");
		}
		
	}
}
