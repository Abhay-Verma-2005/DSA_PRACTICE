class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie t = new Trie();
        for (String word : dictionary) {
            t.insert(word);
        }
        String[] arr = sentence.split(" ");
        StringBuilder  sb= new StringBuilder();
        for(int i=0;i<arr.length;i++){
            String gt=t.search(arr[i]);
            sb.append(gt+" ");
        }
        return sb.toString().trim();
    }
     public class Trie {

        class Node {
            char ch;
            String isterminal;
            HashMap<Character, Node> child;

            Node(char a) {
                ch = a;
                child = new HashMap<>();
                isterminal = null;
            }
        }

        private Node root = new Node('*');

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node(ch));
                curr = curr.child.get(ch);
            }
            curr.isterminal = word;
        }

        public String search(String word) {
            Node curr = root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                    if(curr.isterminal!=null){
                        return curr.isterminal;
                    }
                }
                else{
                    return word;
                }
            }
            return word;
        }
    }
}