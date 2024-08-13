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
class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if((root == null) || (root.left ==null && root.right==null)) return 0;
        return helper(root)[0];
        
    }
    public int[] helper(TreeNode root){
        if((root == null) || (root.left ==null && root.right==null)) return new int[] {0,0};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        if(root.left !=null) left[1]++;
        if(root.right !=null) right[1]++;
        int d = left[1]+right[1];
        return new int[] {Math.max(d, Math.max(left[0],right[0])), Math.max(left[1],right[1]) };
    }


}
