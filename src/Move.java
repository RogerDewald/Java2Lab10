
public enum Move {
	
	LEFT_TO_MIDDLE(Peg.LEFT, Peg.MIDDLE),
	LEFT_TO_RIGHT(Peg.LEFT, Peg.RIGHT),
	MIDDLE_TO_LEFT(Peg.MIDDLE, Peg.LEFT),
	MIDDLE_TO_RIGHT(Peg.MIDDLE, Peg.RIGHT),
	RIGHT_TO_LEFT(Peg.RIGHT, Peg.LEFT),
	RIGHT_TO_MIDDLE(Peg.RIGHT, Peg.MIDDLE);
	
	public final Peg from;
	public final Peg to;
	
	private Move(Peg from, Peg to) throws IllegalArgumentException, NullPointerException{
		if (from == to) {
			throw new IllegalArgumentException();
		}
		if (from == null || to == null) {
			throw new NullPointerException();
		}
		this.from = from;
		this.to = to;
	}
	
	public static Move move(Peg from, Peg to) throws IllegalArgumentException, NullPointerException {
		if (from == to) {
			throw new IllegalArgumentException();
		}
		if (from == null || to == null) {
			throw new NullPointerException();
		}
		if (from == Peg.LEFT) {
			if (to == Peg.RIGHT) {
				return LEFT_TO_RIGHT;
			}
			else {
				return LEFT_TO_MIDDLE;
			}
		}
		else if (from == Peg.RIGHT) {
			if (to == Peg.LEFT) {
				return RIGHT_TO_LEFT;
			}
			else {
				return RIGHT_TO_MIDDLE;
			}
		}
		else {
			if (to == Peg.RIGHT) {
				return MIDDLE_TO_RIGHT;
			}
			else {
				return MIDDLE_TO_LEFT;
			}
		}
	}

}
