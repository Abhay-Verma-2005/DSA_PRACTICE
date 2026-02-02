class Solution {
    ListNode newHead;

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        rev(head);
        return newHead;
    }

    public void rev(ListNode node) {
        if (node.next == null) {
            newHead = node;
            return;
        }
        rev(node.next);
        node.next.next = node;
        node.next = null;
    }
}
