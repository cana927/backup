import java.io.*;
import java.util.*;

public class BitStringFlicking {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String bitstring = sc.nextLine();
		
		bitstring.replaceAll("(", "");
		bitstring.replaceAll(")", "");
		
		String[] list = bitstring.split(" ");
	}
	
	public static String rshift (String num, int shift) {
		String done = "";
		for (int i =0; i<shift; i++) {
			done += "0";
		}
		done += num.substring(0,num.length()-shift);
		return (done);
	}
	public static String lshift (String num, int shift) {
		String done = "";
		done += num.substring(shift);
		for (int i =0; i<shift; i++) {
			done += "0";
		}
		return (done);
	}
	public static String rcirc (String num, int shift) {
		String done = "";
		done = num.substring(num.length()-shift) + num.substring(0,num.length()-shift);
		return (done);
	}
	public static String lcirc (String num, int shift) {
		String done = "";
		done =   num.substring(shift) + num.substring(0, shift) ;
		return (done);
	}
	public static String not (String num) {
		String done = "";
		for (int i =0; i<num.length(); i++) {
			if (num.charAt(i) == '0') {
				done += "1";
			} else {
				done += "0";
			}
		}
		return (done); 
	}
	public static String and (String one, String two) {
		String done = "";
		for (int i =0; i<one.length(); i++) {
			if (one.charAt(i) == '1' && two.charAt(i) =='1') {
				done += "1";
			}else {
				done += "0";
			}
		}
		return (done); 
	}
	public static String xor (String one, String two) {
		String done = "";
		for (int i =0; i<one.length(); i++) {
			if (one.charAt(i) == '1' && two.charAt(i) =='1') {
				done += "0";
			}else if (one.charAt(i) == '0' && two.charAt(i) =='0') {
				done += "0";
			}else {
				done += "1";
			}
		}
		return (done);
	}
	public static String or (String one, String two) {
		String done = "";
		for (int i =0; i<one.length(); i++) {
			if (one.charAt(i) == '1' || two.charAt(i) =='1') {
				done += "1";
			}else {
				done += "0";
			}
		}
		return (done); 
	}
}
