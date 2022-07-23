package _1555;
import java.util.*;

public class BTwoTables {
	static Scanner sc = new Scanner (System.in);
	static int times = sc.nextInt(); 
	static int roomW, roomH;
	static int x1, y1, x2, y2;
	static int rec2W, rec2H;
	static double output; 
	
	public static void main(String [] args) {
		for (int i = 0; i<times; i++) {
			init();
			solve();
			output();
		}
	}
	public static void init() {
		roomW = sc.nextInt();
		roomH = sc.nextInt();
		x1 = sc.nextInt();
		y1= sc.nextInt();
		x2 = sc.nextInt();
		y2 = sc.nextInt();
		rec2W = sc.nextInt();
		rec2H = sc.nextInt();
		output = 0;
	}
	public static void solve() { 
		int rec1W = x2-x1;
		int rec1H = y2-y1; 
		
		
		int updown = -1;
		int side = -1;
		if (rec1W + rec2W > roomW && rec1H + rec2H > roomH) {
			output = -1; 
		} else { 
			//MOVING DOWN
			if (rec2H >(roomH - y2)){ 
				int move = rec2H - (roomH - y2);
				if (move <= y1) {
					updown = move; 
				}
			}else {
				updown = 0; 
			}
			//MOVING UP
			if (rec2H >y1){
				int move = rec2H - y1;
				if (move <= (roomH - y2)) {
					if (updown!= -1 && move < updown) {
						updown = move; 
					}
				}
			}else {
				updown = 0; 
			}
			
			//MOVING LEFT
			if (rec2W >(roomW - x2)){
				int move = rec2W - (roomW - x2);
				if (move <= x1) {
					side = move; 
				}
			}else {
				side = 0; 
			}
			
			//MOVING RIGHT
			if (rec2W >x1){
				int move = rec2W - x1; 
				if (move <= roomW - x2) {
					if (side!= -1 && move < side) {
						side = move; 
					} 
				}
			}else {
				side = 0; 
			}
		}
		if (side == -1 && updown == -1) { 
			output = -1; 
		}else if (side>-1 && updown >-1) { 
			output = Math.min(side, updown);
		} else {
			output = side + updown + 1;  
		}
	}
	public static void output() {
		System.out.println (output);
	}
		
}
