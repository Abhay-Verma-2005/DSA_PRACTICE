class Solution {
    public boolean scoreBalance(String s) {
        int n=s.length();
        int[] l=new int[s.length()];
        int[] r=new int[s.length()];
        char[] ch = s.toCharArray();
        int sum=0;
        for(int i=0;i<ch.length;i++){
            sum+=(ch[i]-'a'+1);
            l[i]=sum;
        }
        sum=0;
        for(int i=ch.length-1;i>=0;i--){
            sum+=(ch[i]-'a'+1);
            r[i]=sum;
        }
        for(int i=0;i<ch.length-1;i++){
            int li=l[i];
            int ri=r[i+1];
            if(li==ri) return true;
        }
        return false;
    }
}