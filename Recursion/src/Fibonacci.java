
public class Fibonacci {
	public static void main (String [] args) {
		for (int i =1; i<=10; i++) {
			System.out.println (fibonacci(i));
		}
	}
	public static int fibonacci(int k) {
		if (k==1) {
			return 1;
		}else if (k==2) {
			return 1;
		}
		else {
			return fibonacci(k-1) + fibonacci (k-2);
		}
	}
}
