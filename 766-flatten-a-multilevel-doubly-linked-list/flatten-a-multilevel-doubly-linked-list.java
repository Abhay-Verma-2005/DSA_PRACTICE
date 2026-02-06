/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null) return null;
        Node curr=head;
        Stack<Node> st= new Stack<>();
        while(curr!=null){
            Node temp=curr;
             if(curr.child!=null){
                if (curr.next != null) { 
                    st.push(curr.next);
                }
                curr.next=curr.child;
                curr.child=null;
                
             }
             else if(curr.child==null && curr.next==null && !st.isEmpty()){
                curr.next=st.pop();
             }

             curr=curr.next;
             if(curr!=null)
             curr.prev=temp;

        }
        return head;
    }
}