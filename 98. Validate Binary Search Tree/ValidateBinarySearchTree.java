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
class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        // Deque<TreeNode> stack = new ArrayDeque<>();
        // TreeNode prev = null;
        // while(!stack.isEmpty() || root !=null){
        //     while(root!=null){
        //         stack.push(root);
        //         root = root.left;
        //     }
        //     root = stack.pop();
        //     if(prev != null && root.val <= prev.val) return false;
        //     prev = root;
        //     root = root.right;
        // }
        // return true;
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        
    }

    public boolean dfs(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val <= min || root.val >= max) return false;
        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
