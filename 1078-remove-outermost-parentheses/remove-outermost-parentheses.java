class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st= new Stack<>();
        String ans="";
        for(char ch:s.toCharArray()){
            if(ch=='(') st.push(ch);
            else st.pop();
            if(st.size()==1 && ch=='(') continue;
            if(st.size()==0) continue;
            ans+=ch;
        }
        return ans;
    }
}