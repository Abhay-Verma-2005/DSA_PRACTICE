class Solution {
    public boolean isAnagram(String s, String t) {
        char[] x = t.toCharArray();
        Arrays.sort(x);
        char[] y = s.toCharArray();
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }
}