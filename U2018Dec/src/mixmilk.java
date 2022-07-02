import java.util.*;
import java.io.*;

public class mixmilk {
	public static void main (String [] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("mixmilk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("shell.out")));
		
		StringTokenizer st;
		
		Bucket [] buckets = new Bucket [4];
		for (int i = 1; i<= 3; i++) {
			st = new StringTokenizer(in.readLine());
			int a = Integer.parseInt(st.nextToken()); 
			int l = Integer.parseInt(st.nextToken());
		}


	} // chagne simulateeeeeeee
	
	public static int simulate (Bucket [] buckets, int num) {
		for (int r = 0; r < buckets[pour].a; r++) {
			int sec = pour + 1;
			if (sec ==4) {
				sec= 1; 
			}
			if (buckets[sec].a <= buckets[sec].l) {
				buckets[pour].a--; 
				buckets[sec].a++; 
			}
			else {
				break; 
			}
		}
		
		pour ++;
		if (pour ==3) {
			pour=1; 
		}
		return ;
	}
}

class Bucket {
	int a, l;
	
	public Bucket (int a, int l) {
		this.a = a;
		this.l = l;
	}
}