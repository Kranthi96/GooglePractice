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
class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // if(root==null) return false;
        // if(root.val == targetSum && root.left==null && root.right==null ) return true;
        // int remSum = targetSum - root.val;
        // return hasPathSum(root.left, remSum) || hasPathSum(root.right, remSum);

        if(root == null) return false;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sums = new Stack<>();
        stack.push(root);
        sums.push(targetSum);
        while(!stack.isEmpty()){
             root = stack.pop();
             targetSum = sums.pop();
             if(root.val == targetSum && root.left==null && root.right==null ) return true;
             targetSum -= root.val;
             if(root.left !=null){
                stack.push(root.left);
                sums.push(targetSum);
             }
             if(root.right !=null){
                stack.push(root.right);
                sums.push(targetSum);
             }
        }
        return false;
    }
}
