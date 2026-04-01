class Solution {
    public int mySqrt(int x) {
        int a = 1;
        int b = x;

        int minInt = 0;
        while (a <= b) {
            int mid = a + (b-a)/2;
            if((x/mid) == mid) {
                return mid;
            } else if ((x/mid) < mid) {
                b = mid - 1;
            } else {
                minInt = mid;
                a = mid + 1;
            }
        }

        return minInt;
        
    }
}