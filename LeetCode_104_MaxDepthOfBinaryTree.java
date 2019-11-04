/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {    
        if (root != null) {
            if (root.left == null && root.right == null) { // leaf node
                return 1;
            }
        
            if (root.left != null && root.right != null) { // has left and right subtree
                int left = 1 + maxDepth(root.left);
                int right = 1 + maxDepth(root.right);
            
                if (left > right) { 
                    return left;
                } else if (right > left) {
                    return right;
                } else {
                    return left;
                }
            
            } else if (root.left != null) { // has left subtree only
                return 1 + maxDepth(root.left);
            } else { // has right subtree only
                return 1 + maxDepth(root.right);
            }
        } else return 0;
    }
}