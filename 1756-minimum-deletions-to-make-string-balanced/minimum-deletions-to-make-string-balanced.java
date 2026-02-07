class Solution {
    public int minimumDeletions(String s) {
        int b = 0;
        int d = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'b') {
                b++;
            } else {
                d = Math.min(d + 1, b);
            }
        }
        return d;
    }
}