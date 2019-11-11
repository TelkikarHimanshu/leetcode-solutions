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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        } else {
            sum = sum - root.val;
        
            if (!hasLeftChild(root) && !hasRightChild(root)) { //leaf node
                if (sum == 0) {
                    return true;
                } else return false;
            } else if (hasLeftChild(root) && hasRightChild(root)) {
                return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
            } else if (hasLeftChild(root)) {
                return hasPathSum(root.left, sum);
            } else {
                return hasPathSum(root.right, sum);
            }   
        }
    }
    
    public boolean hasLeftChild(TreeNode node) {
        if (node.left != null) {
            return true;
        } else return false;
    }
    
    public boolean hasRightChild(TreeNode node) {
        if (node.right != null) {
            return true;
        } else return false;
    }
}