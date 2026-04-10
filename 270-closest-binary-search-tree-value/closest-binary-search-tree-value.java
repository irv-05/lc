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
    public int closestValue(TreeNode root, double target) {
        int closest = root.val;
        double closestDiff = Math.abs(target - closest);
        if(root.val == target) {
            return closest;
        }

        TreeNode cur = target < root.val ? root.left : root.right;
        while(cur != null) {
            double curDiff = Math.abs(target - cur.val);

            if(cur.val == target) {
                return cur.val;
            }

            if((curDiff == closestDiff && cur.val < closest) || curDiff < closestDiff) {
                closest = cur.val;
                closestDiff = curDiff;
            }

            cur = target < cur.val ? cur.left : cur.right;
        }

        return closest;
    }
}