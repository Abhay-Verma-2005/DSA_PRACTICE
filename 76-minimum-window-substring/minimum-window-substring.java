class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];

        for(char c : t.toCharArray()){
            freq[c]++;
        }

        int l = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        for(int r = 0; r < s.length(); r++){

            char c = s.charAt(r);
            freq[c]--;

            while(check(freq)){

                if(r - l + 1 < minLen){
                    minLen = r - l + 1;
                    start = l;
                }

                char left = s.charAt(l);
                freq[left]++;
                l++;
            }
        }

        if(minLen == Integer.MAX_VALUE) return "";

        return s.substring(start, start + minLen);
    }

    public boolean check(int[] freq){
        for(int f : freq){
            if(f > 0) return false;
        }
        return true;
    }
}