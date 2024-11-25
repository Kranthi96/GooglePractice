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
class Sum_Root_to_Leaf_Numbers {
    public int sumNumbers(TreeNode root) {
        List<Integer> resultList = new ArrayList<>();
        getSumToLeaf(root, 0, resultList);
        return resultList.stream().mapToInt(Integer::intValue).sum();
        
    }

    public void getSumToLeaf(TreeNode node, int sum, List<Integer> result){
        sum = sum * 10 + node.val;
        if(node.left == null && node.right == null){
            result.add(sum);
            return;
        }
        if(node.left != null) getSumToLeaf(node.left, sum, result);
        if(node.right != null) getSumToLeaf(node.right, sum, result);
    }
}
