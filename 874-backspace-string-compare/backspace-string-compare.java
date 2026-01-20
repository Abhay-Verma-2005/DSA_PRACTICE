class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st= new Stack<>();
        Stack<Character> st2= new Stack<>();
       for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='#' && !st.isEmpty()) st.pop();
            else if(s.charAt(i)!='#') st.push(s.charAt(i));

       }
       for(int i=0;i<t.length();i++){
            if(t.charAt(i)=='#' && !st2.isEmpty()) st2.pop();
            else if(t.charAt(i)!='#') st2.push(t.charAt(i));        
       }
       if(st.size()!=st2.size()) return false;;
       while(!st.isEmpty()){
        if(st.pop()!=st2.pop()){
            return false;
        }
       }
       return true;
    }
}
