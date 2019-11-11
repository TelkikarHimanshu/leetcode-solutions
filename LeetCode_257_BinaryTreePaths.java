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
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    
    public List<String> binaryTreePaths(TreeNode root) {
        helper(root, sb);
        return list;
    }
    
    public void helper(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        } else {
        
            sb.append(node.val);
        
            if (node.left != null && node.right != null) {
                sb.append("->");
                StringBuilder sb1 = new StringBuilder();
                sb1.append(sb);
                helper(node.left, sb1);
                
                StringBuilder sb2 = new StringBuilder();
                sb2.append(sb);
                helper(node.right, sb2);
            } else if (node.left != null) {
                sb.append("->");                
                helper(node.left, sb);
            } else if (node.right != null) {
                sb.append("->");                
                helper(node.right, sb);
            } else {
                list.add(sb.toString());
            }
        }
    }
}