
public enum Peg {

	LEFT,
	MIDDLE,
	RIGHT;
	
	public static Peg other(Peg p1, Peg p2) throws IllegalArgumentException, NullPointerException {
		if (p1 == p2) {
			throw new IllegalArgumentException();
		}
		else if (p1 == null || p2 == null) {
			throw new NullPointerException();
		}
		else if (p1 == LEFT && p2 == MIDDLE || p1 == MIDDLE && p2 == LEFT) {
			return RIGHT;
		}
		else if (p1 == RIGHT && p2 == MIDDLE || p1 == MIDDLE && p2 == RIGHT) {
			return LEFT;
		}
		else {
			return MIDDLE;
		}
	}
}
