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
class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if(p==null && q==null) return true;
        // if(p==null || q==null || (p.val !=q.val)) return false;
        // return isSameTree(p.left,q.left) && isSameTree(p.right, q.right);

        if(p==null && q==null) return true;
        if(!check(p,q)) return false;

        ArrayDeque<TreeNode> deqP = new ArrayDeque<>();
        ArrayDeque<TreeNode> deqQ = new ArrayDeque<>();
        deqP.addLast(p);
        deqQ.addLast(q);
        while(!deqP.isEmpty()){
            p = deqP.removeFirst();
            q = deqQ.removeFirst();
            if(!check(p,q)) return false;
            if(p!=null){
                if(!check(p.left, q.left)) return false;
                if(p.left!=null){
                    deqP.addLast(p.left);
                    deqQ.addLast(q.left);
                }
                if(!check(p.right, q.right)) return false;
                if(p.right!=null){
                    deqP.addLast(p.right);
                    deqQ.addLast(q.right);
                }
            }
        }
        return true;


    }
    public boolean check(TreeNode p, TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null || (p.val !=q.val)) return false;
        return true;

    }
}
