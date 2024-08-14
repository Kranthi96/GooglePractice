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
class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null) return ans;
        helper(root,0, ans);
        return ans;


        
    }
    public void helper(TreeNode root, int level,List<List<Integer>>levelMap ){
        if(root == null) return;
        if(levelMap.size() == level){
            levelMap.add(new ArrayList<Integer>());
        }
        levelMap.get(level).add(root.val);
        helper(root.left, level+1, levelMap);
        helper(root.right, level+1, levelMap);
    }
}
