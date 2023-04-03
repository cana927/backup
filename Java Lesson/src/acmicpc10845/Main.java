package acmicpc10845;
import java.util.*;

public class Main {
	public static void main (String [] args) {
		LinkedList <Integer> q = new LinkedList <Integer>();
		Scanner sc = new Scanner (System.in);
		
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i =0; i<n; i++) {
			String command = sc.next();
			
			if (command.equals("push")) {
				int num = sc.nextInt();
				q.add(num);
			}
			else if (command.equals("pop")) {
				if (q.isEmpty()) {
					sb.append("-1 \n");
				}else {
					int val = q.poll();
					sb.append(val + "\n");
				}
			}else if (command.equals("size")) {
				sb.append(q.size() + "\n");
			}else if (command.equals("empty")) {
				if (q.isEmpty()) {
					sb.append("1\n");
				} else {
					sb.append("0 \n");
				}
			}else if (command.equals("front")) {
				if (q.isEmpty()) {
					sb.append("-1 \n");
				}else {
					sb.append(q.peek() + "\n");
				}
			}else {
				if (q.isEmpty()) {
					sb.append("-1 \n");
				}else {
					sb.append(q.peekLast() + "\n");
				}
			}
			
		}
		System.out.println (sb);
	}
}
