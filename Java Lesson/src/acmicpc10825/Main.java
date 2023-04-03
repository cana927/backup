package acmicpc10825;
import java.util.*;

public class Main {
	public static class Person implements Comparable <Person> {
		int kor, eng, mat;
		String name;
		
		public Person (String name, int kor, int eng, int mat) {
			this.kor = kor;
			this.eng = eng;
			this.mat = mat;
			this.name = name;
		}
		
		public int compareTo(Person o) {
			if (o.kor > this.kor) {
				return 1;
			}else if (this.kor > o.kor) {
				return -1;
			} else {
				if (o.eng < this.eng) {
					return 1;
				}else if (this.eng < o.eng) {
					return -1;
				} else {
					if (o.mat < this.mat) {
						return -1;
					}else if (this.mat < o.mat) {
						return 1;
					} else {
						for (int i =0; i<Math.min(this.name.length(),  o.name.length()); i ++) {
							if (this.name.charAt(i) > o.name.charAt((i))) { 
								return 1;
							}
							if (this.name.charAt(i) < o.name.charAt((i))) { 
								return -1;
							}
						}
					}
				}
			}
			return 0;
		}
	}
	
	public static void main (String [] args) {
		Scanner sc = new Scanner (System.in);
		int n = sc.nextInt();
		Person [] persons = new Person [n];
		for (int i =0; i<n; i++ ) {
			persons [i] = new Person (sc.next(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(persons);
		for (int i =0; i<n; i++) {
			System.out.println(persons[i].name);
		}
	}
}
