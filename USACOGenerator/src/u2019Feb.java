import java.util.*;
import java.io.*;

public class u2019Feb {
	public static void main (String [] args) throws IOException{
		PrintWriter pw = new PrintWriter (new BufferedWriter (new FileWriter("traffic.out")));
		int N = 10;
		pw.println(N);
		for (int i =0; i<N; i++) {
			int r = (int) (Math.random() * 3);
			if (r==0) pw.print("on ");
			else if (r==1) pw.print("none "); 
			else if (r==2) pw.print("off ");
			
			int kRange = 100;
			int firstVal = (int) (Math.random()*kRange);
			int secVal = (int) (Math.random() * kRange);
			while (secVal<firstVal) secVal = (int)(Math.random()*kRange);
			pw.println(firstVal + " " + secVal);
		}
		pw.close();
				
	}
}
