package _339;

import java.util.Arrays;
import java.util.Scanner;

public class AHelpfulMaths {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String r = sc.next ();
		String [] a = r.split("\\+");
		Arrays.sort(a);
		
		for ( int i= 0; i<a.length-1 ; i++) {
			System.out.print (a[i] + "+");
		}
		System.out.print (a[a.length-1]);
		
	}
}
