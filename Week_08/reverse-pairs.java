class Solution {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return 0;
        }
        int mid = (start + end) >>> 1;
        int count = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);
        int[] temp = new int[end - start + 1];
        int index = 0;
        int lo = start, hi = mid + 1;
        int pos = lo;
        for ( ; hi <= end; hi++, index++) {
            while (pos <= mid && nums[pos++] / 2.0 <= nums[hi]);
            while (lo <= mid && nums[lo] < nums[hi]) { temp[index++] = nums[lo++]; }
            count += mid - (--pos) + 1;
            temp[index] = nums[hi];
        }
        while (lo <= mid) { temp[index++] = nums[lo++]; }
        System.arraycopy(temp, 0, nums, start, temp.length);
        return count;
    }
}
