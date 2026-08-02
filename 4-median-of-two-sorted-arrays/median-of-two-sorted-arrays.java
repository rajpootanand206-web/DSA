class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //Ensure number 1 is smaller Array
        if(nums1.length>nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int left = 0, right = m;
        int half = (m + n + 1) / 2; // size of left partition

        while (left <= right) {
            int i = (left + right) / 2;   // partition index in nums1
            int j = half - i;             // partition index in nums2

            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

            if (left1 <= right2 && left2 <= right1) {
                // Correct partition found
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                } else {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
            } else if (left1 > right2) {
                right = i - 1; // move partition left in nums1
            } else {
                left = i + 1;  // move partition right in nums1
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }
}      
    