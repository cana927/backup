import java.util.ArrayList;

public class Task2 implements Runnable {
	public void run () {
		ArrayList<Integer>a1 = new ArrayList <Integer>();
		for (int i = 0; i<10_000; i++) {
			a1.add((int)(Math.random() * 1_000_000_000));
		}
		
		while (true) {
			boolean sorted = true;
			for (int i =1; i<10_000; i++) {
				if (a1.get(i) < a1.get(i-1)) {
					int temp = a1.get(i);
					a1.set(i, a1.get(i-1));
					a1.set(i-1, temp);
					sorted = false;
				}
			}
			if (sorted) {
				break;
			}
		}
		for (int i=0; i<100; i++) {
			System.out.print (a1.get(i) + " ");
		}
		System.out.println ();
	}
}
