class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) {
            return false;
        }

        int a = 10;
        int b = 1;
        while(x/b >= 10) {
            b*=10;
        }

        while(b > 1) {
            int left = x/b;
            int right = x%a;
            if(left != right) {
                return false;
            }

            if(left!=0) {
                x%=(left*b);
            }

            x/=10;
            b/=100;
        }

        return true;
    }
}