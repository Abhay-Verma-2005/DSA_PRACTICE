/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->Integer.compare(a.val,b.val));
        for(ListNode nn: lists){
            if(nn!=null) pq.offer(nn);
        }
        ListNode head= new ListNode();
        ListNode ans= head;
        while(!pq.isEmpty()){
            ListNode rm=pq.poll();
            ListNode newNode= new ListNode(rm.val);

            head.next=newNode;
            head=head.next;
            rm=rm.next;
            if(rm!=null){
                pq.add(rm);
            }
        }
        return ans.next;
    }
}