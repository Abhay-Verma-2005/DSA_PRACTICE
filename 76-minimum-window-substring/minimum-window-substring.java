class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int c=Integer.MAX_VALUE;
        StringBuilder ans=new StringBuilder("");
        HashMap<Character,Integer> Smap=new HashMap<>();
        HashMap<Character,Integer> Tmap=new HashMap<>();
        for(char ch:t.toCharArray()){
            Tmap.put(ch,Tmap.getOrDefault(ch,0)+1);
        }
        int l=0;
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            //grow
            Smap.put(ch,Smap.getOrDefault(ch,0)+1);
            if(i-l+1>=m){
                while(check(Smap,Tmap)){

                    if(i-l+1<c){
                        c = i-l+1;
                        ans = new StringBuilder(s.substring(l,i+1));
                    }

                    char chr = s.charAt(l);
                    Smap.put(chr, Smap.get(chr)-1);
                    l++;
                }
            }
        }
            return ans.toString();

    }
    public boolean check(HashMap<Character,Integer> Smap ,HashMap<Character,Integer> Tmap){
        for(char ele:Tmap.keySet()){
            if(!Smap.containsKey(ele) || Smap.get(ele) < Tmap.get(ele)){
                return false;
            }

        }
        return true;
    }
}