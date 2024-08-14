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
class MinimumAbsoluteDifferenceInBST {
    int minDiff = Integer.MAX_VALUE;
    TreeNode prevNode;
    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return minDiff;
    }

    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        if(prevNode !=null){
            minDiff = Integer.min(minDiff, root.val - prevNode.val);
        }
        prevNode = root;
        inOrder(root.right);

    }
    
}
