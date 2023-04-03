package acmicpc10814;
import java.util.*;

public class Main {
	public static class Person implements Comparable <Person> {
		int age, order;
		String name;
		
		public Person (int age, int order, String name) {
			this.age = age;
			this.order = order;
			this.name = name;
		}
		
		public int compareTo(Person o) {
			if (o.age < this.age) {
				return 1;
			}else if (this.age<o.age) {
				return -1;
			} else {
				return this.order - o.order;
			}
		}
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		Person [] persons = new Person [n];
		for (int i =0; i<n; i++ ) {
			persons [i] = new Person (sc.nextInt(), i, sc.next());
		}
		Arrays.sort(persons);
		for (int i =0; i<n; i++) {
			System.out.println(persons[i].age + " " + persons[i].name);
		}
	}
}
