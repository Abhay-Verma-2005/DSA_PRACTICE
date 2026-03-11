class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int c=Integer.MAX_VALUE;
        StringBuilder ans=new StringBuilder("");
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int l=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            //grow
            freq[(int) ch]--;
            if(i-l+1>=m){
                while(check(freq)){
                    if(i-l+1<c){
                        c = i-l+1;
                        ans = new StringBuilder(s.substring(l,i+1));
                    }
                    char chr = s.charAt(l);
                    if(t.contains(chr+"")){
                        freq[(int)chr]++;
                    }
                    l++;
                }
            }
        }
        return ans.toString();

    }
    public boolean check(int[] freq){
        for(int ele:freq){
            if(ele>0) return false;
        }
        return true;
    }
}