class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int max = 0; 
        
        for (char ch : tasks) {
            freq[ch - 'A']++;
            max = Math.max(max, freq[ch - 'A']);
        }
        int t=0;
        for(int i=0;i<26;i++){
            if(freq[i]==max){
                t++;
            }
        }
        return Math.max(tasks.length ,(max-1)*(n+1)+t);

    }
}