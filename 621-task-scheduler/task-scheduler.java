class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxm = 1; 
        
        for (char ch : tasks) {
            freq[ch - 'A']++;
            maxm = Math.max(maxm, freq[ch - 'A']);
        }
        
        int maxcnt = 0;
        for (int x : freq) {
            if (x == maxm) {
                maxcnt++;
            }
        }
        
        return Math.max(tasks.length, (n + 1) * (maxm - 1) + maxcnt);
    }
}