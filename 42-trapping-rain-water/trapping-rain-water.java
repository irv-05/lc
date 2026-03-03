class Solution {
    // two pointers, start from both ends
    public int trap(int[] height) {
        int a = 0;
        int b = height.length-1;
        while(a < b && height[a] == 0) {
            a++;
        }

        while(a < b && height[b] == 0) {
            b--;
        }

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

        System.out.println("level is" + level);
System.out.println(water);
        while(a < b) {
            if(height[a] <= level) {
                a++;
                if(a!=b) {
                    water -= Math.min(height[a], level);
                }
                System.out.println("a" + water);
            } else if(height[b] <= level) {
                b--;
                if(a!=b) {
                    water -= Math.min(height[b], level);
                }
                System.out.println("b" + water);

            } else {
                int oldLevel = level;
                level = Math.min(height[a], height[b]);
                water += (b - a - 1) * (level-oldLevel);
                System.out.println(water);
            }
        }

        /*if(a == b && a > 0 && a < height.length-1) {
            water -= Math.min(height[a], level);
        }*/

        return water;
    }
}