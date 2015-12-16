package datastructures.map;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharacterInStringInOneLoop {

	public static void main(String[] args) {
        Character character = firstNonRepeatingCharacter("nnjkljklhihis");
        System.out.println("First Non repeating character :  " + (character != null ? character : null));
    }

    private static Character firstNonRepeatingCharacter(String arg) {
        char[] characters = arg.toCharArray();
        Map<Character, Character> set = new LinkedHashMap<>();
        // cost of the operation is O(n)
        for (char c : characters) {
            if (set.containsKey(c)) {
                set.remove(c);
            } else {
                set.put(c, c);
            }
        }
        //here we are just getting the first value from collection
        // not iterating the whole collection and the cost of this operation is O(1)
        Iterator<Character> iterator = set.keySet().iterator();
        if (iterator.hasNext()) {
            return iterator.next();
        } else {
            return null;
        }
    }

}
