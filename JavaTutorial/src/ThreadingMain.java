
public class ThreadingMain {

	public static void main (String [] args) {
		Task1 t1 = new Task1();
		Task2 t2 = new Task2();
		
		long big1 = System.nanoTime();
		/*
		long time1 = System.nanoTime();
		t1.run();
		long time2 = System.nanoTime();
		System.out.println ((time2 - time1) / 1_000_000_000.0);
		
		long time1a = System.nanoTime ();
		t2.run();
		long time2a = System.nanoTime ();
		System.out.println ((time2a - time1a)/ 1_000_000_000.0);
		*/
		//multithreading - runs parallel to main thread
		// the time for main ends already while th1 and 2 continue to take a few more sec
		Thread th1 = new Thread (t1);
		Thread th2 = new Thread (t2);
		th1.start();
		th2.start();
		long big2 = System.nanoTime();
		System.out.println ((big2-big1)/1_000_000_000.0);
	}
}