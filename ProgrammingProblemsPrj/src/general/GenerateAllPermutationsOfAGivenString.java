package general;

import java.util.ArrayList;
import java.util.List;


public class GenerateAllPermutationsOfAGivenString {
	static String in = "abcde";
	static char[] array = in.toCharArray();
	static boolean[] used = new boolean[array.length];
	static StringBuffer out = new StringBuffer();
	List<String> permutations = new ArrayList();

	public static void main(String[] args) {
		permute();
	}

	public static void permute() {
		if (out.length() == in.length()) {
			System.out.println(out);
			return;
		}
		for (int i = 0; i < in.length(); ++i) {
			if (used[i])
				continue;
			out.append(in.charAt(i));
			used[i] = true;
			permute();
			used[i] = false;
			out.setLength(out.length() - 1);
		}
	}
}
