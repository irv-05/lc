// 1,2,3 1,5
// O(log(x)*log(y)))
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length == 0) {
            return findSingleMedian(nums2);
        } else if(nums2.length == 0) {
            return findSingleMedian(nums1);
        }
        //the algorithm is different if the whether the sum of the length of the arrays is odd or even
        if((nums1.length+nums2.length)%2 == 1) {
            return findMedianSortedArraysOdd(nums1,nums2);
        }
        return findMedianSortedArraysEven(nums1,nums2);
    }

    public double findSingleMedian(int[] nums) {
        if(nums.length%2 == 1) {
            return nums[nums.length/2];
        } else {
            return ((double)nums[(nums.length/2) - 1] + (double)nums[nums.length/2]) / 2;
        }
    }

    public double findMedianSortedArraysOdd(int[] nums1, int[] nums2) {
        double pass1 = binarySearch(nums1, nums2, false);
        if(pass1 != Integer.MAX_VALUE) {
            return pass1;
        } else {
            return binarySearch(nums2,nums1, false);
        }
    }

    public double findMedianSortedArraysEven(int[] nums1, int[] nums2) {
        double bound1 = binarySearch(nums1, nums2, true);
        if(bound1 == Integer.MAX_VALUE) {
            bound1 = binarySearch(nums2, nums1, true);

        }
        System.out.println(bound1);
        double bound2 = binarySearch(nums1, nums2, false);
        if(bound2 == Integer.MAX_VALUE) {
            bound2 = binarySearch(nums2, nums1, false);
        }
        System.out.println(bound2);

        return (bound1+bound2) / 2;
    }

    public double binarySearch(int[] start, int[] comp, boolean leftBound) {
        int halfsize = (start.length + comp.length) /2;
        //look for the number in array 1
        int a = 0; 
        int b = start.length;
        int half = b / 2;
        while(a < b) {
            int num = start[half];
            int target = halfsize - half;
            if(leftBound) {
                target-=1;
            }

            if(comp.length >= target && (target-1 < 0 || comp[target-1] <= num)) {
                if(target >= 0 && (comp.length < target+1 || comp[target] >= num)) {
                    return num;
                } else {
                    b = half;
                }
            } else {
                a = half + 1;
            }
            half = a + ((b-a)/2);
        }

        return Integer.MAX_VALUE;
    }
}