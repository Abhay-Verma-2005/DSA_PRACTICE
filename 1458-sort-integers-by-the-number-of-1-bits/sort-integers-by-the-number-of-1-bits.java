import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed, (a, b) -> {
            int bitCompare = Integer.compare(Integer.bitCount(a), Integer.bitCount(b));
            return bitCompare != 0 ? bitCompare : Integer.compare(a, b);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }

        return arr;
    }
}