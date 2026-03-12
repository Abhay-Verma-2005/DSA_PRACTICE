class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        String a="";
        for(char ch:s.toCharArray()){
            if((ch>='a' && ch<='z') || (ch>='0' && ch<='9')){
                a+=ch;
            }
        }
        System.out.println(a);
        int st=0;
        int en=a.length()-1;
        while(st<en){
            if(a.charAt(st)!=a.charAt(en)){
                return false;
            }
            st++;
            en--;
        }
        return true;
    }
}