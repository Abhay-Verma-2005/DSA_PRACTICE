class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        ArrayList<Integer> ans = new ArrayList<>();

        if (s.length() < p.length()) return ans;

        int[] arr = new int[26];

        for (char ch : p.toCharArray()) {
            arr[ch - 'a']++;
        }

        for (int i = 0; i < p.length(); i++) {
            arr[s.charAt(i) - 'a']--;
        }

        for (int i = p.length(); i < s.length(); i++) {
            if (check(arr)) ans.add(i - p.length());

            arr[s.charAt(i - p.length()) - 'a']++;
            arr[s.charAt(i) - 'a']--;
        }

        if (check(arr)) ans.add(s.length() - p.length());

        return ans;
    }

    public boolean check(int[] arr) {
        for (int e : arr) {
            if (e != 0) return false;
        }
        return true;
    }
}