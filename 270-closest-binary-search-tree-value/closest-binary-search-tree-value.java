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
        double closestDiff = Math.abs(target - root.val);
        while(root != null) {
            double curDiff = Math.abs(target - root.val);

            if(root.val == target) {
                return root.val;
            }

            if((curDiff == closestDiff && root.val < closest) || curDiff < closestDiff) {
                closest = root.val;
                closestDiff = curDiff;
            }

            root = target < root.val ? root.left : root.right;
        }

        return closest;
    }
}