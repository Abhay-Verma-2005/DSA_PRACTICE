class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ArrayList<Integer> ll= new ArrayList<>();
        while(head!=null){
            ll.add(head.val);
            head=head.next;
        }
        return createTree(ll,0,ll.size()-1);

    }
    public TreeNode createTree(ArrayList<Integer> ll, int lo, int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;
        TreeNode nn=new TreeNode(ll.get(mid));
        nn.left=createTree(ll,lo,mid-1);
        nn.right=createTree(ll,mid+1,hi);
        return nn;
    }
}