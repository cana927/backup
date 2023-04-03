package acmicpc1158;

import java.util.*;

public class Main {
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		String output = "<";

		int n = sc.nextInt();
		int s = sc.nextInt();
		
		Queue <Integer> q = new LinkedList <Integer> ();
		
		for (int i =1; i<=n; i++) {
			q.add(i);
		}
		
		while (q.size()>0) {
			for (int i =0; i<s; i++) {
				if (i == s-1) {
					output += q.peek() + ", ";
					q.poll();
				} else {
					int val = q.poll();
					q.add(val);
				}
			}
		}
		output = output.substring(0, output.length()-2) + ">";
		System.out.println (output);
	}
}


/*
does not work

Scanner sc = new Scanner (System.in);
String output = "<";

int n = sc.nextInt();
int s = sc.nextInt();

ArrayList <Integer> a = new ArrayList<Integer>();
for (int i =1; i<=n; i++) {
	a.add(i);
}

while (a.size()>0) {
	int place = s%a.size()-1;
	if (place <0) {
		place = a.size()-1;
	}
	output += a.get(place) + ", ";
	a.remove(place);
}

output = output.substring(0, output.length()-2) + ">";
System.out.println (output);
*/