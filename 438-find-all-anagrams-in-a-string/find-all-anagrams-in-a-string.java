class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int k = p.length();
        int[] pCount = new int[26];
        for (char ch : p.toCharArray()) pCount[ch - 'a']++;
        
        for (int i = 0; i <= s.length() - k; i++) {
            int[] subCount = new int[26];
            for (int j = i; j < i + k; j++) {
                subCount[s.charAt(j) - 'a']++;
            }
            if (Arrays.equals(subCount, pCount)) {
                ans.add(i);
            }
        }
        
        return ans;
    }
}