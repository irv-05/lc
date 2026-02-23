class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        int xflip = 0;
        int i = x;
        while(i != 0) {
            xflip = (xflip*10) + i%10;
            i/=10;
        }

        return xflip == x;
    }
}