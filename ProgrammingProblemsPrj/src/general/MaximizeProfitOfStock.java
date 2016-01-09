package general;

public class MaximizeProfitOfStock {

	// 4 3 9 1 2 5 0 10 8 7

	public static void main(String[] args) {
		int difference = 0;
		 int[] stockValues = new int[] { 4, 3, 9, 1, 2, 5, 0, 10, 8, 7 };
		//int[] stockValues = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int stockBuyPos = 0;
		int finalBuyPos = 0;
		int finalSellPos = 0;

		validateInput(stockValues);

		//O(n)
		for (int i = 0; i < stockValues.length; i++) {
			int newDifference = stockValues[i] - stockValues[stockBuyPos];
			if (newDifference > difference) {
				finalBuyPos = stockBuyPos;
				finalSellPos = i;
				difference = newDifference;
			}
			if (stockValues[i] < stockValues[stockBuyPos]) {
				stockBuyPos = i;
			}
		}
		System.out.println("Stock Pos >>> " + finalBuyPos + " >>>> "
				+ finalSellPos + " >> Difference : " + (stockValues[finalSellPos] - stockValues[finalBuyPos]));

	}

	private static void validateInput(int[] stockValues) {
		int prevStockValue = stockValues[0];
		boolean isValid = false;
		for (int stockValue : stockValues) {
			if (stockValue > prevStockValue) {
				isValid = true;
			}
		}
		if (!isValid) {
			throw new IllegalArgumentException(
					"Cannot apply algorithm on input sorted in descending order");
		}
	}

}
