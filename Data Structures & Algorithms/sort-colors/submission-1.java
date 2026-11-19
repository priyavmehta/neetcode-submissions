class Solution {
    public void sortColors(int[] nums) {
        int start = 0, end = nums.length - 1;

        while (end >= 0 && nums[end] == 2) end--;
        while (start <= end && nums[start] == 0) start++;

        int i = start;
        while (i <= end) {
            if (nums[i] == 0) {
                nums[i] = 1;
                nums[start] = 0;
                start++;
                i++;
            } else if (nums[i] == 2) {
                nums[i] = nums[end];
                nums[end] = 2;
                end--;
            } else {
                i++;
            }
        }
    }
}