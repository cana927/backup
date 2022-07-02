package traverse;
import java.util.*;

public class FPizza {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int desiredRadius = sc.nextInt();
		double tolerance = sc.nextDouble();
		
		//all radii given in input (this is is guaranteed to be correct)
		ArrayList<Integer> r = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			r.add(sc.nextInt());
		}
		Collections.sort(r);
		
		//answer to problem
		long result = 0;
		
		for (int i = 0; i < r.size(); i++) {
			//find largest radius that can fit within tolerance when combined to area of the i-th radius
			int upperBound = (int) Math.ceil(Math.sqrt(tolerance/Math.PI - desiredRadius * (long) desiredRadius 
					- r.get(i) * (long) r.get(i)));
			
			//find smallest radius sr that can fit within tolerance when combined to area of the ith radius
			int lowerBound = (int) Math.sqrt(desiredRadius * (long) desiredRadius 
					- r.get(i) * (long) r.get(i) + tolerance/Math.PI);
			
			
			//get lowestIndex >= i in r that has radius greater than or equal to lowerBound
			int lowerIndex = lower_bound(r, lowerBound, i + 1);
			
			
			//get highestIndex >= i in r that has radius less than or equal to upperBound
			int upperIndex = upper_bound(r, upperBound, i + 1);
			
			if (lowerIndex == -1 || upperIndex == -1)
			{
				continue;
			}
			result += upperIndex - lowerIndex + 1;
		}
		System.out.println(result);
	}
	static int upper_bound(ArrayList<Integer> arr, int key, int start) {
		//todo: find highest index i >= start such that the ith value in arr is <= key
		//if no index exists, return -1
		int ind = -1;
		for (int i = start; i<arr.size(); i++) {
			if (arr.get(i) <= key) {
				if (i>ind) {
					ind = i;
				}
			}
		}
		 
		return ind;
	}
	static int lower_bound(ArrayList<Integer> arr, int key, int start) {
		//todo: find lowest index i >= start such that the ith value in arr is >= key
		//if no index exists, return -1
		int ind = -1;
		for (int i = start; i<arr.size(); i++) {
			if (arr.get(i) >= key) {
				if (i<ind) {
					ind = i;
				}
			}
		}
		 
		return ind;
	}

}