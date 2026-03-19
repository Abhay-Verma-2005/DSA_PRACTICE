class Solution {
    public int compress(char[] chars) {
        String s="";
        int freq=1;
        char prev=chars[0];
        for(int i=1;i<chars.length;i++){
            char curr=chars[i];
            if (curr != prev) {
                s += prev;
                if (freq > 1) s += freq;
                prev = curr;
                freq = 1;
            } else {
                freq++;
            }
        }
        s += prev;
        if (freq > 1) s += freq;
        System.out.println(s);
        int i=0;
        for(char ch:s.toCharArray()){
            chars[i]=ch;
            i++;
        }
        return s.length();
    }
}