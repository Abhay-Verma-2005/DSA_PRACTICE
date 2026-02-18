/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int Camera=0;
    public int minCameraCover(TreeNode root) {
        int c=minCamera(root);
        if(c==-1){
            Camera++;
        }
        return Camera;
    }
    public int minCamera(TreeNode root) {
        if(root == null) return 0;
        int left = minCamera(root.left);
        int right = minCamera(root.right);

        if(left==-1 || right==-1){
            // is node ko cam ki need h
            Camera++;
            return 1; 
        }
        else if(left==1 || right==1){
            // inme se koi ek ke pass ya dono ke pass cam h , 
             return 0; //islka matlb covered hu 
        }
        else{
            return -1;
        }
    }
}

// // import java.util.*;
// import java.lang.*;

// class Main
// {
//     public static void main (String[] args) throws java.lang.Exception
//     {
//         Scanner sc= new Scanner(System.in);
//         int t=sc.nextInt();
//         while(t--> 0){
//             String s=sc.next();
//             String k=sc.next();
//             Karps(s,k);  
//             System.out.println();
//         }
//     }

//     public static void Karps(String s, String p){
//         if(p.length()>s.length()) return;

//         long hv=0;
//         long pow=1;
//         long pr=31;
//         long mod=1000000007;

//         for(int i=0;i<p.length();i++){
//             hv=(hv + ((p.charAt(i)-'a'+1)*pow)%mod)%mod;
//             pow=(pow*pr)%mod;
//         }

//         int n=s.length();
//         long[] dp= new long[n];
//         long[] pa=new long[n];

//         pa[0]=1;
//         for(int i=1;i<n;i++){
//             pa[i]=(pa[i-1]*pr)%mod;
//         }

//         dp[0]=s.charAt(0)-'a'+1;
//         for(int i=1;i<n;i++){
//             dp[i]= (dp[i-1] + ((s.charAt(i)-'a'+1)*pa[i])%mod)%mod;
//         }

//         List<Integer> ll= new ArrayList<>();
//         int m=p.length();

//         for(int i=0;i+m-1<n;i++){
//             long curr = dp[i+m-1];
//             if(i>0){
//                 curr = (curr - dp[i-1] + mod) % mod;
//             }

//             if(curr == (hv * pa[i]) % mod){
//                 ll.add(i+1);
//             }
//         }

//         for(int x: ll) System.out.print(x+" ");
//     }
// }
