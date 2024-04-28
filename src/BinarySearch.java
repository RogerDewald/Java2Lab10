import java.util.ArrayList;
import java.util.List;

public class BinarySearch {

	/**
	 * Search a sorted list of strings using binary search. Return a list of
	 * the indices of the strings checked during the search in the order they
	 * are checked. If the target string is not found, append -1 to the end of
	 * the list. Otherwise, the last element is the index of the target.
	 *
	 * @param strings  the list to be searched
	 * @param target  the string to be searched for
	 * @param fromIdx  the index of the first string in the range of strings to
	 *                 be searched (inclusive)
	 * @param toIdx  the index of the last string in the range of strings to be
	 *               searched (inclusive)
	 * @return a list of the indices of the strings checked during the search.
	 *         If the target is not in the list, the last element is -1.
	 */
	public static List<Integer> binarySearch(List<String> strings,
			String target, int fromIdx, int toIdx) {
		ArrayList<Integer> iList = new ArrayList<Integer>();
		if (fromIdx > toIdx) {
			iList.add(-1);
			return iList;
		}
		int midIdx = (fromIdx + toIdx)/2;
		iList.add(midIdx);
		if (strings.get(midIdx).compareTo(target) == 0) {
			return iList;
		}
		else if (strings.get(midIdx).compareTo(target) < 0) {
			fromIdx = midIdx + 1;
			List<Integer> bot = binarySearch(strings, target, fromIdx, toIdx);
			iList.addAll(bot);
		}
		else if (strings.get(midIdx).compareTo(target) > 0){
			toIdx = midIdx - 1;
			List<Integer> top = binarySearch(strings, target, fromIdx, toIdx);
			iList.addAll(top);
		}
		return iList;
	}
}
