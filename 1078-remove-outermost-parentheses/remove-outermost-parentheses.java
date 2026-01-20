class Solution {
    public String removeOuterParentheses(String s) {
        int p=0;
        String ans="";
        for(char ch:s.toCharArray()){
            if(ch=='(') p++;
            else p--;
            if(p==1 && ch=='(') continue;
            if(p==0) continue;
            ans+=ch;
        }
        return ans;
    }
}