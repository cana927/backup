import java.util.*;

public class numberConversion {
	public static void main (String [] args) {
		System.out.println( Integer.toHexString(10));         //a
	    System.out.println( Integer.toOctalString(10));      //12
	    System.out.println( Integer.toBinaryString(10));     //1010

	    System.out.println( Integer.parseInt("1010", 2));     //10
	    System.out.println( Integer.parseInt("12", 8));     //10
	    System.out.println( Integer.parseInt("A", 16));     //10    

	}
}