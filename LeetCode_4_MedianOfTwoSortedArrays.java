class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0f;
            } else return nums2[nums2.length / 2];
        } else if (nums2.length == 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0f;
            } else return nums1[nums1.length / 2];
        } else {
            int[] combined = new int[nums1.length + nums2.length];
            int i = 0, j = 0, pointer = 0;
            while (i < nums1.length && j < nums2.length) {
                if (nums1[i] <= nums2[j]) {
                    combined[pointer] = nums1[i];
                    i++;
                } else {
                    combined[pointer] = nums2[j];
                    j++;
                }
                pointer++;
            }
            
            if (i == nums1.length) {
                for (int k = j; k < nums2.length; k++) {
                    combined[pointer] = nums2[k];
                    pointer++;
                }
            }
            
            if (j == nums2.length) {
                for (int k = i; k < nums1.length; k++) {
                    combined[pointer] = nums1[k];
                    pointer++;
                }
            }
            
            if (combined.length % 2 == 0) {
                return (combined[combined.length / 2] + combined[combined.length / 2 - 1]) / 2.0f;
            } else {
                return combined[combined.length / 2];
            }
        }
    }
}