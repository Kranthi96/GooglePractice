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
class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        int left_depth =0, right_depth=0;
        if(root.left !=null) left_depth = height(root.left)+1;
        if(root.right !=null) right_depth = height(root.right)+1;
        if(Math.abs(left_depth-right_depth) >1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int height(TreeNode root){
        if((root == null) || (root.left==null && root.right == null))
            return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
}
