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
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int nodes = 0;
        TreeNode cur = root;
        int level = 0;
        while(cur.left != null) {
            cur = cur.left;
            level++;
        }
        int val = (int)Math.pow(2,level);
        int max = val - 1 + (int) Math.pow(2, level);
        int min = val;

        int a = min;
        int b = max;


        while(a <= b) {
            int mid = a + (b-a) / 2;
            boolean found = findNode(min, max, root, mid);
            if(found) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }

        return b;
        
    }

    private boolean findNode(int min, int max, final TreeNode root, int num) {
        TreeNode cur = root;
        int a = min;
        int b = max;
        int val = 1;
        while(cur != null && val != num) {
            int mid = a + (b-a) / 2;
            if(num > mid) {
                cur = cur.right;
                a = mid + 1;
                val = 1 + (val*2);
            } else {
                cur = cur.left;
                b = mid - 1;
                val = val*2;
            }
        }

        return cur != null;
    }
}