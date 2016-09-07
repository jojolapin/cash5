import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class Cash5 {
	private List<String> indexList = new ArrayList<String>();

	/**
	 * This function generates a random List of numbers pick up from the input
	 * List. The size of the generated list will depend of the second parameter
	 * of the function. -JI
	 * 
	 * @param
	 * @return random index number for selecting the corresponding random List
	 *         values. -JI
	 */
	public List<String> getRandomList(List<String> list, int listSize) {
		List<String> randomList = new ArrayList<String>();
		for (int i = 0; i < listSize; i++) {
			randomList.add(getRandomIdex(list));
		}
		return randomList;
	}

	private String getRandomIdex(List<String> list) {
		int index = ThreadLocalRandom.current().nextInt(list.size());
		// To avoid repetitions
		while (indexList.contains(String.valueOf(index))) {
			index = ThreadLocalRandom.current().nextInt(list.size());
		}
		indexList.add(String.valueOf(index));
		// System.out.println("IndexList: = " + indexList);
		return list.get(index);
	}

	/**
	 * This function takes two lists, join them together and returns the joined
	 * list. -JI
	 * 
	 * @param
	 * @return
	 */
	public ArrayList<String> joinList(List<String> list1, List<String> list2) {
		Set<String> set1 = new HashSet<String>(list1);
		Set<String> set2 = new HashSet<String>(list2);
		Set<String> union = new HashSet<String>();

		union.addAll(set1);
		union.addAll(set2);

		return new ArrayList<String>(union);
	}

	private void combinationUtil(int arr[], int data[], int start, int end, int index, int r) {
		// Current combination is ready to be printed, print it
		if (index == r) {
			for (int j = 0; j < r; j++)
				System.out.print(data[j] + " ");
			System.out.println("");
			return;
		}
		for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
			data[index] = arr[i];
			combinationUtil(arr, data, i + 1, end, index + 1, r);
		}
	}

	/**
	 * This function takes a list of size n = list.size, a r value for combination calculations
	 * and returns all combinations of size r from the list in an array.
	 * 
	 * The main function that prints all combinations of size r in arr[] of size
	 * n. This function mainly uses combinationUtil().  -JI
	 * 
	 * @param
	 * @return
	 */
	public void findCombinationOf(List<String> list, int r) {
		int[] arr = new int[list.size()];
		// A temporary array to store all combination one by one
		int data[] = new int[r];
		String[] stringArr = list.toArray(new String[list.size()]);

		for (int i = 0; i < list.size(); i++) {
			try {
				arr[i] = Integer.parseInt(stringArr[i]);
			} catch (NumberFormatException nfe) {
			}
		}

		// Print all combination using temprary array 'data[]'
		combinationUtil(arr, data, 0, list.size() - 1, 0, r);
	}
}
