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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0;
        ListNode dummy=new ListNode();
        ListNode head=dummy;
        while(l1!=null && l2!=null){
            ListNode node=new ListNode();
            int a=l1.val+l2.val+carry;
            carry=a/10;
            node.val=a%10;
            dummy.next=node;
            dummy=dummy.next;
            l1=l1.next;
            l2=l2.next;
        }
        if(l1==null && l2!=null){
            dummy.next=l2;
            while(l2!=null){
                int a=l2.val+carry;
                carry=a/10;
                l2.val=a%10;
                dummy = l2;
                l2=l2.next;
            }
        }
        if(l2==null && l1!=null){
            dummy.next=l1;
            while(l1!=null){
                int a=l1.val+carry;
                carry=a/10;
                l1.val=a%10;
                dummy = l1;
                l1=l1.next;
            }
        }
        if(carry==1){
             dummy.next = new ListNode(1);
        }
        return head.next;
    }
}