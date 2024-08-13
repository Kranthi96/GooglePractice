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
class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        // return isSame(root.left, root.right);
        Queue<TreeNode> deq = new LinkedList<>();
        deq.add(root);
        deq.add(root);
        while(!deq.isEmpty()){
            TreeNode p = deq.poll();
            TreeNode q = deq.poll();
            if(p==null && q==null) continue;
            if(p==null || q==null) return false;
            if(p.val != q.val) return false;
            deq.add(p.left);
            deq.add(q.right);
            deq.add(p.right);
            deq.add(q.left);
        }
        return true;

    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null || p.val != q.val) return false;
        return isSame(p.left, q.right) && isSame(p.right, q.left);


       

    }
}
