class Solution {
    public int lengthOfLongestSubstring(String s) {
        int c=0;
        int st=0;
        HashSet<Character> set= new HashSet<>();
        for(int e=0;e<s.length();e++){
            while(set.contains(s.charAt(e))){
                set.remove(s.charAt(st++));
            }
            set.add(s.charAt(e));
            c=Math.max(c,e-st+1);
        }
        return c;
    }
}