package datastructures.array;

/**
 * Goal of this is to find a solution in O(n) time. There is a straight forward
 * solution for this using O(n^2) time which uses nested for loops.
 * 
 * @author akshay
 *
 */
public class FindMaximumPossibleDifferenceOfAnyTwoGivenElementsInArray {

	public static void main(String[] args) throws Exception {
		// random sequence 1
		double[] array = new double[] { 2.0d, 1.0d, 5.0d, 2.0d, 15.0d, 6.0d,
				10.0d, 3.0d };
		int[] lowerAndUpper = findMaximumPossibleDifference(array);
		System.out.println("Lower >>>" + lowerAndUpper[0] + " >>>> Upper >>> "
				+ lowerAndUpper[1] + " >>> Difference >>>>"
				+ (array[lowerAndUpper[1]] - array[lowerAndUpper[0]]));
		// random sequence 2
		array = new double[] { 15.0d, 13.0d, 10.0d, 3.0d, 5.0d };
		lowerAndUpper = findMaximumPossibleDifference(array);
		System.out.println("Lower >>>" + lowerAndUpper[0] + " >>>> Upper >>> "
				+ lowerAndUpper[1] + " >>> Difference >>>>"
				+ (array[lowerAndUpper[1]] - array[lowerAndUpper[0]]));

		// decreasing sequence
		array = new double[] { 15.0d, 13.0d, 10.0d, 8.0d, 5.0d };
		lowerAndUpper = findMaximumPossibleDifference(array);
		System.out.println("Lower >>>" + lowerAndUpper[0] + " >>>> Upper >>> "
				+ lowerAndUpper[1] + " >>> Difference >>>>"
				+ (array[lowerAndUpper[1]] - array[lowerAndUpper[0]]));

		// increasing sequence
		array = new double[] { 5.0d, 8.0d, 10.0d, 13.0d, 15.0d };
		lowerAndUpper = findMaximumPossibleDifference(array);
		System.out.println("Lower >>>" + lowerAndUpper[0] + " >>>> Upper >>> "
				+ lowerAndUpper[1] + " >>> Difference >>>>"
				+ (array[lowerAndUpper[1]] - array[lowerAndUpper[0]]));

	}

	private static int[] findMaximumPossibleDifference(double[] prices)
			throws Exception {
		if (prices == null || prices.length < 2) {
			throw new IllegalArgumentException();
		}
		int[] returnArray = new int[2];
		double min = prices[0];
		int minPosition = 0;
		int maxPosition = 0;
		double difference = 0;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < min) {
				min = prices[i];
				minPosition = i;
				maxPosition = i;
			} else if ((prices[i] - min) > difference) {
				difference = prices[i] - min;
				maxPosition = i;
			}
		}
		returnArray[0] = minPosition;
		returnArray[1] = maxPosition;
		return returnArray;
	}

}
