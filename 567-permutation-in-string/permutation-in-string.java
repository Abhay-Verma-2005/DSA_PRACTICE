class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] arr= new int[26];
        for(char ch:s1.toCharArray()){
            arr[ch-'a']++;
        }
        if(s2.length()<s1.length()) return false;
        for(int i=0;i<s1.length();i++){
                arr[s2.charAt(i)-'a']--;
        }
        for(int i=s1.length();i<s2.length();i++){
            if(check(arr)) return true;
            arr[s2.charAt(i-s1.length())-'a']++;
            arr[s2.charAt(i)-'a']--;
        }
        return check(arr);
    }
    public boolean check(int[] arr){
        for(int e:arr){
            if(e!=0){
                return false;
            }
        }
        return true;
    }
}