class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n = s.length();

        for (int i = 0; i < n; i++) {

            int l = i;
            int r = i + 1;
            String m = "";

            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                m = s.charAt(l) + m + s.charAt(r);
                l--;
                r++;
            }

            if (m.length() > ans.length()) {
                ans = m;
            }

            m = "" + s.charAt(i);
            l = i;
            r = i;

            while (l - 1 >= 0 && r + 1 < n && s.charAt(l - 1) == s.charAt(r + 1)) {
                l--;
                r++;
                m = s.charAt(l) + m + s.charAt(r);
            }

            if (m.length() > ans.length()) {
                ans = m;
            }
        }

        return ans;
    }
}