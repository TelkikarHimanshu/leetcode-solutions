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
     List<List<Integer>> listOfList = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        helper(root, sum, new ArrayList<>());
        return listOfList;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> list) {
        if (root != null) {
            sum = sum - root.val;
        list.add(root.val);
        
        if (!hasLeftChild(root) && !hasRightChild(root)) {
            if (sum == 0) {
                listOfList.add(list);
                return;
            } else return;
        }
        
        if (hasLeftChild(root) && hasRightChild(root)) {
            List<Integer> list1 = new ArrayList<>();
            for (int i : list) {
                list1.add(i);
            }
            
            List<Integer> list2 = new ArrayList<>();
            for (int i : list) {
                list2.add(i);
            }
            helper(root.left, sum, list1);
            helper(root.right, sum, list2);
            

        } else if (hasLeftChild(root)) {
            helper(root.left, sum, list);
        } else {
            helper(root.right, sum, list);
        }
        } else {
            return;
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