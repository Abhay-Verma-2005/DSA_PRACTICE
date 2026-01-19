class Solution {
    public int calPoints(String[] op) {
        List<Integer> l=new ArrayList<>();
        int sum=0;
        for(String opr:op){
            if(opr.equals("C")){
                l.remove(l.size()-1);
            }
            else if(opr.equals("D")){
                l.add(l.get(l.size()-1)*2);
            }
            else if(opr.equals("+")){
                l.add( l.get(l.size()-1) + l.get(l.size()-2));
            }
            else{
                l.add(Integer.parseInt(opr));
            }
        }
        for(int val:l){
            sum+=val;
        }
        return sum;

    }
}