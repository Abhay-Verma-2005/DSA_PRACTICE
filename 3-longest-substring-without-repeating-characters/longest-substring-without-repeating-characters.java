import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int e = 0; e < s.length(); e++){
            while(set.contains(s.charAt(e))){
                set.remove(s.charAt(st++));
            }
            set.add(s.charAt(e));
            max = Math.max(max, e - st + 1);

        }

        return max;
    }
}