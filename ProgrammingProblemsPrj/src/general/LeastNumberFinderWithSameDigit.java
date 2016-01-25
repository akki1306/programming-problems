package general;


/**
 * Find next least number with same digit For ex. - input: 23654 -> output:
 * 23456, input: 2654 -> output: 4256
 * 
 * This can be done using straight forward method 1. Find all possible
 * permutations of given number. 2. Get the smallest of the permutations
 * calculated which is not same as the given number.
 * 
 * We will implement using another approach here.
 */
public class LeastNumberFinderWithSameDigit {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] inputprovided = new Integer[] { 23654, 12345, 72153, 54321 };
		for (int k = 0; k < inputprovided.length; k++) {
			Integer[] array = getIntArray(inputprovided[k]);
			int minNumber = array[array.length - 1];
			int minNumberPosition = array.length - 1;
			boolean isFound = false;
			for (int i = array.length - 1; i >= 0; i--) {
				if (array[i] < minNumber) {
					isFound = true;
					swap(i, minNumberPosition, array);
					sort(i + 1, array.length - 1, array);
					break;
				}
			}
			if (!isFound) {
				throw new IllegalArgumentException("Cannot find next number");
			} else {
				System.out.println("Number is :" + getNumber(array));
			}
		}
	}

	//O(n)
	static Integer[] getIntArray(Integer number) {
		Integer[] array = new Integer[number.toString().length()];
		int index = array.length - 1;
		int digit;
		while (number > 0) {
			digit = number % 10;
			array[index--] = digit;
			number = number / 10;
		}
		return array;
	}

	//O(1) space and O(1) time. 
	static void swap(int index1, int index2, Integer[] array) {
		int temp = array[index2];
		array[index2] = array[index1];
		array[index1] = temp;
	}

	//O(n^2)
	static void sort(int index1, int index2, Integer[] array) {
		for (int i = index1; i <= index2; i++) {
			for (int j = i + 1; j <= index2; j++) {
				if (array[i] > array[j]) {
					swap(i, j, array);
				}
			}
		}
	}

	//O(n)
	static Integer getNumber(Integer[] array) {
		int number = 0;
		int factor = 1;
		for (int i = array.length - 1; i >= 0; i--) {
			number += array[i] * factor;
			factor = factor * 10;
		}
		return number;
	}
}
