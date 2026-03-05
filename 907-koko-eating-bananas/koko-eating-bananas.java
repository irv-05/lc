// we can do binary search. we know that the maximum k will always be equals to the maximum pile size. Aything higher
// will always give the same h value. so we start at this max, find the h. At every point, if our target is higher we go up half,
// if lower we go down half. Since every k computation takes n steps (where n is the length of piles), then the solution is nlogn. 
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //find max k
        int high = 0;
        for(int pile : piles) {
            if(pile > high) {
                high = pile;
            }
        }

        long curTime = piles.length;
        int bestK = high;
        //if h == piles.length, then lets just return the value
        if(h == curTime) {
            return bestK;
        }

        int low = 0;
        int mid = (high + low) / 2;
        while(low != high-1) {
            boolean onTime = isOnTime(piles, mid, h);
            if(!onTime) {
                low = mid;
                mid = (high + low) / 2;

            } else {
                if(mid < bestK) {
                    bestK = mid;
                }

                high = mid;
                mid = (high + low) / 2;
            }
        }

        return bestK;
    }

    private boolean isOnTime(int[] piles, int k, int h) {
        long time = 0;
        for(int pile : piles) {
            double val = Math.ceil((double) pile / (double) k);
            time += (long) val;
            if(time > h) {
                return false;
            }
        }

        return true;
    }
}