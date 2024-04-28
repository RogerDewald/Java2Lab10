import java.util.Collections;
import java.util.Deque;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

public class TowerOfHanoi {
	
	private Map<Peg, Deque<Integer>> diskStacks;
	
	public TowerOfHanoi(int numDisks, Peg start) throws IllegalArgumentException, NullPointerException {
		if (numDisks <= 0) {
			throw new IllegalArgumentException();
		}
		if (start == null) {
			throw new NullPointerException();
		}
		diskStacks = Map.of(
				Peg.LEFT, new LinkedList<>(),
				Peg.RIGHT, new LinkedList<>(),
				Peg.MIDDLE, new LinkedList<>() );
	
		for (int i = numDisks; i > 0; i--) {
			diskStacks.get(start).push(i);
		}
	}
	
	public Deque<Integer> getDiskStack(Peg peg) throws IllegalArgumentException{
		if (peg == null) {
			throw new IllegalArgumentException();
		}
		return new LinkedList<>(diskStacks.get(peg));
	}
	
	public void moveDisk(Move move) throws NullPointerException, IllegalArgumentException {
		if (move == null) {
			throw new NullPointerException();
		}
		else if (diskStacks.get(move.from) == null || diskStacks.get(move.from).peek() > diskStacks.get(move.to).peek()) {
			throw new IllegalArgumentException();
		}
		diskStacks.get(move.to).push(diskStacks.get(move.from).pop());
	}
	
	public String toString() {
		return "LEFT: " + diskStacks.get(Peg.LEFT) + System.lineSeparator() +
		"MIDDLE: " + diskStacks.get(Peg.MIDDLE) + System.lineSeparator() +
		"RIGHT: " + diskStacks.get(Peg.RIGHT);
	}
	
	public static List<Move> solve(int numDisks, Peg start, Peg end) throws IllegalArgumentException, NullPointerException{
		if (numDisks < 0) {
			throw new IllegalArgumentException();
		}
		if (start == null || end == null) {
			throw new NullPointerException();
		}
		if (numDisks == 0) {
			return new LinkedList<Move>();
		}
		Peg other = Peg.LEFT;
		if (start == Peg.LEFT && end == Peg.MIDDLE || start == Peg.MIDDLE && end == Peg.LEFT) {
			other = Peg.RIGHT;
		}
		else if (start == Peg.LEFT && end == Peg.RIGHT || start == Peg.RIGHT && end == Peg.LEFT) {
			other = Peg.MIDDLE;
		}
		else if (start == Peg.MIDDLE && end == Peg.RIGHT || start == Peg.RIGHT && end == Peg.MIDDLE) {
			other = Peg.LEFT;
		}
		
		List<Move> moves = solve(numDisks - 1, start, other);
		moves.add(Move.move(start, end));
		return moves;
}

}
