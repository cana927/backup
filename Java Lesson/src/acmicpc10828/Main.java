package acmicpc10828;
import java.util.*;

public class Main {
	public static void main(String [] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<n; i++) {
			String command = sc.next();
			if (command.equals("push")) {
				int num = sc.nextInt();
				s.push(num);
			}
			else if (command.equals ("pop")) {
				if (s.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					int val = s.pop();
					sb.append(val + "\n");
				}
			}
			else if (command.equals("size")) {
				int size = s.size();
				sb.append (size + "\n");
			}
			else if (command.equals("empty")){
				if(s.isEmpty()) {
					sb.append ("1 \n");
				}else {
					sb.append("0 \n");
				}
			}
			else {
				if (s.isEmpty()) {
					sb.append("-1\n");
				}
				else {
					sb.append(s.peek() + "\n");
				}			
			}
		}
		System.out.println (sb.toString());
	}
}
