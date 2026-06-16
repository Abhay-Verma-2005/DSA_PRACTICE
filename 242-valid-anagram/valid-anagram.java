class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        int[] freq=new int[26];
        for(int i=0;i<s.length();i++){
            freq[t.charAt(i)-'a']++;
            freq[s.charAt(i)-'a']--;
        }
        for(int ele: freq){
            if(ele!=0) return false;
        }
        return true;
    }
}