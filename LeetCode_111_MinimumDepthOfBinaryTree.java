/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeetCode_111_MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
       if (root == null) {
           return 0;
       } else {
           if (root.left == null && root.right == null) {
           return 1;
           } 
        
           if (root.left != null && root.right != null) {
               int sum1 = 1 + minDepth(root.left);
               int sum2 = 1 + minDepth(root.right);
               if (sum1 <= sum2) {
                   return sum1;
               } else return sum2;
           } else if (root.left != null) {
               return 1 + minDepth(root.left);
           } else {
               return 1 + minDepth(root.right);
           }
       }
    }
}