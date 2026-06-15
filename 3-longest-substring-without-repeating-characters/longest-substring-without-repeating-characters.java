import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int st = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(st++));
            }
            set.add(s.charAt(i));
            max=Math.max(max,i-st+1);
        }

        return max;
    }
}