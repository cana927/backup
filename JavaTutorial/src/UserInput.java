import java.util.Scanner;
public class UserInput {
	public static void main(String [] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.next ();
		System.out.println(a);
		
		int b = sc.nextInt();
		System.out.println (b);
	}
}
// 1 s 3 first token: 1 but next token : s, cannot convert to int