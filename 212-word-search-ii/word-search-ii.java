class Solution {
    static ArrayList<String> ll;

    public List<String> findWords(char[][] board, String[] words) {
        ll = new ArrayList<>();
        Trie t = new Trie();

        for (String s : words) {
            t.insert(s);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (t.root.child.containsKey(board[i][j])) {
                    t.search(board, i, j, t.root);
                }
            }
        }
        return ll;
    }

    public class Trie {
        class Node {
            char ch;
            String isterminal;
            HashMap<Character, Node> child = new HashMap<>();

            Node(char a) {
                ch = a;
            }
        }

        public Node root = new Node('*');

        public void insert(String word) {
            Node curr = root;
            for (char ch : word.toCharArray()) {
                curr.child.putIfAbsent(ch, new Node(ch));
                curr = curr.child.get(ch);
            }
            curr.isterminal = word;
        }

        public void search(char[][] board, int i, int j, Node node) {
            // bounds + visited
            if (i < 0 || j < 0 || i >= board.length || j >= board[0].length)
                return;

            char ch = board[i][j];

            if (ch == '*' || !node.child.containsKey(ch))
                return;

            node = node.child.get(ch);

            if (node.isterminal != null) {
                ll.add(node.isterminal);
                node.isterminal = null; // avoid duplicates
            }

            board[i][j] = '*';

            search(board, i + 1, j, node);
            search(board, i - 1, j, node);
            search(board, i, j + 1, node);
            search(board, i, j - 1, node);

            board[i][j] = ch;
        }
    }
}
