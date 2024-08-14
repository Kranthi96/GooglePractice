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
class KthSmallestElementInABST {
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) return -1;
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list.get(k-1);
    }
    public List<Integer>  helper(TreeNode node, List<Integer> list ){
        if(node == null) return null;
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
        return list;
    }
}
