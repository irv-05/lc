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
        
        if(p != null) {
            pstack.push(p);
        }

        if(q != null) {
            qstack.push(q);
        }

        if(qstack.size() != pstack.size()) {
            return false;
        }

        while(!pstack.isEmpty()) {
            TreeNode curP = pstack.pop();
            TreeNode curQ = qstack.pop();

            if(curP.val != curQ.val) {
                return false;
            }

            //left
            if(curP.left == null && curQ.left != null) {
                return false;
            } else if(curQ.left == null && curP.left != null) {
                return false;
            } else if(curP.left != null) {
                pstack.push(curP.left);
                qstack.push(curQ.left);
            }

            //right
            if(curP.right == null && curQ.right != null) {
                return false;
            } else if(curQ.right == null && curP.right != null) {
                return false;
            } else if(curP.right != null) {
                pstack.push(curP.right);
                qstack.push(curQ.right);
            }
        }

        return true;
    }

}