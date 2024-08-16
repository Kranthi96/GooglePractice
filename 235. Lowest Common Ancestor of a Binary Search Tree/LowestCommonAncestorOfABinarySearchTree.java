/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class LowestCommonAncestorOfABinarySearchTree {
    TreeNode ans = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        recursiveCall(root, p, q);
        return ans;
    }
    public boolean recursiveCall(TreeNode root,  TreeNode p, TreeNode q){
        if(root == null) return false;
        int isLeft = recursiveCall(root.left, p, q)? 1 : 0;
        int isRight = recursiveCall(root.right, p, q)? 1 : 0;
        int isMiddle = (root.val == p.val || root.val == q.val) ? 1 :0 ;
        if((isLeft + isRight + isMiddle ) >=2)
            ans = root;
        return (isLeft + isRight + isMiddle) >0;
        
    }
}
