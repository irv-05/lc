//2,3,4,5,6,8 9
//2,3,4,4,4,4,4,4,4,25,25,99,99,99,99 50
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0;
        int b = numbers.length-1;

        while(numbers[a]+numbers[b] != target) {
            if(numbers[a]+numbers[b] < target) {
                a++;
            } else {
                b--;
            }
        }

        int[] ret = new int[2];
        ret[0] = a+1;
        ret[1] = b+1;
        return ret;
    }
}