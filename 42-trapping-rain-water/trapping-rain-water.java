class Solution {
    // two pointers, start from both ends
    public int trap(int[] height) {
        int a = 0;
        int b = height.length-1;
        if(a >= b) {
            return 0;
        }

        int level = Math.min(height[a], height[b]);
        int water = (b - a - 1) * level;

        if(height[a] <= level) {
            a++;
            if(a!=b) {
                water -= Math.min(height[a], level);
            }
        } 

        if(height[b] <= level) {
            b--;
            if(a!=b) {
                water -= Math.min(height[b], level);
            }
        }

        while(a < b) {
            if(height[a] <= level) {
                a++;
                if(a!=b) {
                    water -= Math.min(height[a], level);
                }
            } else if(height[b] <= level) {
                b--;
                if(a!=b) {
                    water -= Math.min(height[b], level);
                }

            } else {
                int oldLevel = level;
                level = Math.min(height[a], height[b]);
                water += (b - a - 1) * (level-oldLevel);
            }
        }

        return water;
    }
}