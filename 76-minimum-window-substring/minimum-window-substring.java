class Solution {
    public String minWindow(String s, String t) {

        int[] freq = new int[128];
        for(char c : t.toCharArray()){
            freq[c]++;
        }
        int l = 0;
        int Len = Integer.MAX_VALUE;
        int st = 0;
        for(int r = 0; r < s.length(); r++){
            char c = s.charAt(r);
            freq[c]--;
            while(check(freq)){
                if(r-l+1<Len){
                    Len=r-l+1;
                    st=l;
                }
                char left=s.charAt(l);
                freq[left]++;
                l++;
            }
        }

        if(Len == Integer.MAX_VALUE) return "";

        return s.substring(st, st + Len);
    }

    public boolean check(int[] freq){
        for(int f : freq){
            if(f > 0) return false;
        }
        return true;
    }
}