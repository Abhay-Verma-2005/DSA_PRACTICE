class Solution {
    public String countAndSay(int n) {
        return recur("1",n-1);
    }
    public String recur(String s,int n){
        if(n==0) return s;
        int c=1;
        String new_s="";
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
            }
            else{
                new_s+=c+""+s.charAt(i-1);
                c=1;
            }
        }
        new_s+=c+""+s.charAt(s.length()-1);
        return recur(new_s,n-1);
    }
}
