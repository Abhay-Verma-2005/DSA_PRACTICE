class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map= new HashMap<>();
        for(String s:strs){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String item = new String(ch);
            if(!map.containsKey(item)) map.put(item,new ArrayList<>());
            map.get(item).add(s);
        }
        return new ArrayList<>(map.values());
    }
}