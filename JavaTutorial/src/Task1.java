import java.util.ArrayList;

public class Task1 implements Runnable{
	public void run () { // need to be added with implements runnable
		ArrayList<Integer> a1 = new ArrayList <Integer> ();
		for (int i=2; i<10_000; i++) { // _ doesn't affect num
			boolean isDivisible = false; 
			for (int j = 2; j<Math.sqrt(i); j++) {
				if (i % j ==0) {
					isDivisible = true;
				}
			}
			if (!isDivisible) {
				a1.add(i);
			}
		}
		for (int i = 0; i<100; i++) {
			System.out.print (a1.get(i) + " ");
		}
		System.out.println ();
	}
}
