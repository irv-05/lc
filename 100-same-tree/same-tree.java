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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> pstack = new ArrayDeque<>();
        Deque<TreeNode> qstack = new ArrayDeque<>();

        if(!compareNodes(p, q)) {
            return false;
        }
        
        if(p != null) {
            pstack.push(p);
            qstack.push(q);
        }

        while(!pstack.isEmpty()) {
            TreeNode curP = pstack.pop();
            TreeNode curQ = qstack.pop();

            //left
            if(!compareNodes(curP.left, curQ.left)) {
                return false;
            } else if(curP.left != null) {
                pstack.push(curP.left);
                qstack.push(curQ.left);
            }


            //right
            if(!compareNodes(curP.right, curQ.right)) {
                return false;
            } else if(curP.right != null) {
                pstack.push(curP.right);
                qstack.push(curQ.right);
            }
        }

        return true;
    }

    private boolean compareNodes(TreeNode q, TreeNode p) {
        if(p == null && q != null) {
            return false;
        } else if(q == null && p != null) {
            return false;
        } else if(q != null) {
            return q.val == p.val;
        }

        return true;
    }
}