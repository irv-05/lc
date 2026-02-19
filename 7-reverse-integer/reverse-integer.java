//-999999
//99999
class Solution {
    private final int MAX_INT = Integer.MAX_VALUE;
    private final int MIN_INT = Integer.MIN_VALUE;
    public int reverse(int x) {
        int sig = 1;
        int cur = x;
        int reversed = 0;

        //first, lets find the most significant digit location
        int largestSig = 1;
        boolean maxSig = false;
        while(!maxSig && x/largestSig != 0) {
            if(largestSig > MAX_INT/10) {
                maxSig = true;
            } else {
                largestSig*=10;
            }
        }

        if(!maxSig) {
            largestSig/=10;
        }

        while(cur!=0) {
            int curDigit = cur / largestSig;
            if(outOfBounds(reversed, curDigit, sig)) {
                return 0;
            }
            reversed+= curDigit*sig;
            cur-= curDigit*largestSig;
            largestSig/=10;

            if((sig > MAX_INT/10) && cur!=0) {
                return 0;
            }

            sig*=10;
        }

        return reversed;
    }

    public boolean outOfBounds(int reversed, int curDigit, int sig) {
        //negative numbers
        if(curDigit < 0 && (curDigit < MIN_INT/sig || reversed < (MIN_INT - (curDigit*sig)))) {
            return true;
        //positive numbers
        } else if (curDigit > 0 && (curDigit > MAX_INT/sig || reversed > (MAX_INT - (curDigit*sig)))) {
            return true;
        }
        
        return false;
    }
}