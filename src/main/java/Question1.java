import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

/*
 * Write a Java method that takes an array of "sets" of String objects,
 and determines whether _all_ sets in the array are equivalent.

 Each "set" in the input array is represented as an array of String objects, in
 no particular order, and possibly containing duplicates. Nevertheless, when
 determining whether two of these "sets" are equivalent, you should disregard
 order and duplicates. For example, the sets represented by these arrays are
 all equivalent:

 {"a", "b"}
 {"b", "a"}
 {"a", "b", "a"}

 The signature for your method should be:

 public static boolean allStringSetsIdentical(String[ ][ ] sets)

 Examples of the method in operation:

 allStringSetsIdentical(new String[][] {{"a","b"},{"b","b","a"},{"b","a"}})
 returns true

 allStringSetsIdentical(new String[][] {{"a","b"},{"a"},{"b"}}) returns false
 */

public class Question1 {

    public boolean allStringSetsIdentical(String[][] input) {
        if (input == null) return false;
        List<SortedSet<String>> list = Arrays.stream(input)
                                             .map(array -> new TreeSet<>(Arrays.asList(array)))
                                             .collect(Collectors.toList());
        return list.stream().allMatch(strings -> Arrays.deepEquals(list.get(0).toArray(), strings.toArray()));

    }
}
