// [2,4,5,6,7,0,1]
// [5,6,7,0,1,2,4]
// [7,0,1,2,4,5,6]
class Solution {
    public int search(int[] nums, int target) {
        //first binary search is to find the rotation index by trying to find the max val
        int a = 0;
        int b = nums.length - 1;
        int index = -1;
        int maxVal = - 1;
        while(a < b) {
            int mid = a + ((b-a)/2);
            if(nums[mid] > maxVal) {
                maxVal = nums[mid];
            }
            if(valueOf(nums,mid-1) < nums[mid] && valueOf(nums,mid+1) < nums[mid]) {
                index = mid;
                break;
            } else if(valueOf(nums,mid-1) > nums[mid]) {
                index = mid - 1;
                break;
            } else if (maxVal > nums[mid]) {
                b = mid - 1;
            } else {
                a = mid + 1;
            }
        }


        //if index is still -1, it was on the left, so now find the min val
        if(index == -1) {
            a = 0;
            b = nums.length - 1;
            int minVal = Integer.MAX_VALUE;
            while(a < b) {
                int mid = a + ((b-a)/2);
                if(nums[mid] < minVal) {
                    minVal = nums[mid];
                }

                if(valueOf(nums,mid-1) > nums[mid] && valueOf(nums,mid+1) > nums[mid]) {
                    index = mid;
                    break;
                } else if(valueOf(nums,mid+1) < nums[mid]) {
                    index = mid + 1;
                    break;
                } else if (minVal < nums[mid]) {
                    a = mid + 1;
                } else {
                    b = mid - 1;
                }
            }
        } else {
            //we must know the 0 index not the max index, so shift one.
            index++;
        }

        //if we still didn't find, then there is no rotation
        if(index == -1) {
            index = 0;
        }

        //now find the target
        a = 0;
        b = nums.length - 1;
        while (a <= b) {
            int mid = a + ((b-a)/2);
            int curVal = valueOf(nums, mid+index);
            if(curVal == target) {
                return mathMod(mid+index, nums.length);
            } else if(curVal < target) {
                a = mid + 1;
            } else {
                b = mid - 1;
            }
        }

        return -1;        
    }

    //rotation safe index of
    public int valueOf(int [] nums, int target) {
        return nums[mathMod(target, nums.length)];
    }

    public int mathMod(int a , int b) {
        return ((a % b) + b) % b;
    }
}