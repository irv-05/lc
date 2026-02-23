class Solution {
    public boolean isPalindrome(int x) {
        if(x ==0) {
            return true;
        }
        
        if(x<0 || x%10 == 0) {
            return false;
        }

        int xflip = 0;
        while(x > xflip) {          
            xflip = (xflip*10) + x%10;
            if(x == xflip) {
                return true;
            }

            x/=10;
        }

        return x==xflip;
    }
}