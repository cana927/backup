
public class binaryConversion {
	public static void main (String [] args) {
		System.out.println (cnvtToDec("1011"));
	}
	public static int cnvtToDec(String binary) {
		int dec = 0;
		for (int i =0; i<binary.length(); i++) {
			int bin = binary.charAt(binary.length() -1-i) - '0';
			dec += Math.pow(2, i) * bin ; 
		}
		return dec;
	}
}
