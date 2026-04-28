class Solution {
    public boolean checkRecord(String s) {
        int a=0;
        int i=0;
        for(char ch: s.toCharArray()){
            if(ch=='A'){
                a++;
            }
            if(i>1 && ch=='L' && ch==s.charAt(i-1) && ch==s.charAt(i-2)){
                return false;
            }
            if(a>=2){
                return false;
            }
            i++;
        }
        return true;
    }
}