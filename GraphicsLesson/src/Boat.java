import java.util.ArrayList;

public class Boat {
	
	public static final char HORIZONTAL = 'h';
	public static final char VERTICAL = 'v'; //exists permanently 
	
	private int x, y;
	private int size;
	private char orientation;
	
	public Boat (int x, int y, int size, char orientation) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.orientation = orientation;
	}
	
	public void setPosition (int newX, int newY) {
		x = newX;
		y = newY;
	}
	
	public void setOrientation (char orientation) {
		this.orientation = orientation;
	}
	
	public int getX () {
		return x;
	}
	
	public int getY () {
		return y;
	}
	
	public char getOrientation () {
		return orientation;
	}
	
	public int getSize () {
		return size; 
	}
	
	public boolean isBoat (int checkX, int checkY) {
		if (orientation == HORIZONTAL) {
			for (int i=x; i<=x+size; i++) {
				if (i == checkX && y == checkY) {
					return true;
				}
			}
			return false;
		}
		else {
			for (int i=y; i<= y+size; i++) {
				if (x== checkX && i == checkY) {
					return true;
				}
			}
			return false; 
		}
	}
		
	public boolean isNearBoat (int checkX, int checkY) {

		if (orientation == HORIZONTAL ) {
			for (int i=0; i<size; i++) {
				if (checkX == x +i && (checkY == y-1||checkY==y+1)) {
					return true; 
				}
			}
			if (checkX == x-1 && checkY == y) {
				return true; 
			}
			if (checkX == x+size && checkY == y) {
				return true;			
			}
			if (checkX == x-1 && checkY == y-1) {
				return true;
			}
			if (checkX == x-1 && checkY == y+1) {
				return true; 
			}
			if ( checkX  == x+size && checkY == y-1) {
				return true;
			}
			if (checkX == x+size && checkY == y+1) {
				return true;
			}
		}else {
			for (int i=0; i<size; i++) {
if ((checkX == x-1 || checkX == x+1)&& checkY == y+i) {
					return true;
				}
			}
			if (checkX == x && checkY == y-1) {
				return true;
			}
			if (checkX == x && checkY == y+size) {
				return true;
			}
			if (checkX ==x-1 && checkY == y-1) {
				return true;
			}
			if (checkX == x+1 && checkY == y-1) {
				return true;
			}
			if (checkX == x-1 && checkY == y+size) {
				return true;
			}
			if (checkX == x+1 && checkY == y+size) {
				return true;
			}
		}
		return false; 
	}
	
	public String toString() {
			return "Boat: \n" + 
	                    "\tx: " + x + " y: " + y + "\n" +
					    "\tsize: " + size + "\n" +
	                    "\torientation: " + orientation;
		}

	
	public static boolean tryToPlaceBoat (ArrayList<Boat> placedBoats, Boat toPlace) {
		for (Boat b: placedBoats) {
			for (int i=0; i<toPlace.size; i++) {
				if (toPlace.orientation == HORIZONTAL) {
					if (b.isBoat(toPlace.x + i, toPlace.y) || b.isNearBoat(toPlace.x+i, toPlace.y)) {
						return false;
					}
				}
				else {
					if (b.isBoat(toPlace.x,  toPlace.y+i) || b.isNearBoat(toPlace.x, toPlace.y+i)) {
						return false; 
					}
				}
			}
		}
		return true;
	}
	
	public static void randomizeBoats (ArrayList <Boat> boats) {
		//randomize orientation
		for (Boat b: boats) {
			double orProb = Math.random();
			if (orProb < 0.5) {
				b.setOrientation(HORIZONTAL);
			} else {
				b.setOrientation (VERTICAL);
			}
		}
		
		//randomize the location
		ArrayList<Boat> placedBoats = new ArrayList<Boat>();
		for (int i=0; i<boats.size(); i++) {
			Boat b = boats.get(i);
			int randX = (int) (Math.random()*10);
			int randY = (int) (Math.random()*10);
			if (b.orientation == HORIZONTAL) {
				if (randX + b.size-1 >= 10) {
					i--; 
					continue;
				}
			}
			else {
				if (randY + b.size -1 >=10) {
					i--;
					continue;
				}
			}
			b.setPosition(randX, randY);
			if (tryToPlaceBoat(placedBoats, b)) {
				placedBoats.add(b); 
			}
			else {
				i--; 
			}
		}
	}

}
