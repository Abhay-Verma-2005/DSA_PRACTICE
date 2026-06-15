class Solution {
    public String longestPalindrome(String s) {
        String ans = "";
        int n=s.length();
        for(int i=0;i<n;i++){
            int l=i;
            int r=i+1;
            String m="";
            //for even;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                m=s.charAt(l)+m+s.charAt(l);
                l--;
                r++;
            }
            if(m.length()>ans.length()) ans=m;

            // for odd
            m=""+s.charAt(i);
            l=i-1;
            r=i+1;
            while(l>=0 && r<n && s.charAt(l)==s.charAt(r)){
                m=s.charAt(l)+m+s.charAt(r);
                l--;
                r++;
            }
            if (m.length() > ans.length()) {
                ans = m;
            }
        }
        return ans;
    }
}