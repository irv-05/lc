// [3,1,1,1,2,2,2,2,3,3,3,10,10,3,3,3,3,2,2,2,2,1,1,1]
// [2,1,1,1,1,10,1,1]
// [1,2,3,4,5,4,3,2,1]
class Solution {
    public int maxArea(int[] height) {
        int[] largest = new int[height.length];
        int curTop = largest[0];
        for(int i = 1; i < largest.length; i++){
            if(curTop > height[i]) {
                largest[i] = -1;
            } else {
                largest[i] = 1;
                curTop = height[i];
            }
        }

        int a = 0;
        int b = height.length - 1;
        int max = 0;

        while(a<b) {
            int i = b;
            int ha = height[a];

            boolean leftLimit = false;
            while(a<i && !leftLimit) {
                int hi = height[i];
                int cur = Math.min(ha,hi) * (i-a);
                if(cur >= max) {
                    max = cur;
                }

                if(hi >= ha || largest[i] == 1) {
                    leftLimit = true;
                }

                i--;
            }

            //advance b
            while(a<b && ha>=height[b] && largest[b] == -1) {
                b--;
            }


            //advance a
            a++;
            while(a<b && ha>=height[a]) {
                a++;
            }
 
        }

        return max;
        
    }
}