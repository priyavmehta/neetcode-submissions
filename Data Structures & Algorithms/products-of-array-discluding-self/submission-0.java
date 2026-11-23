class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];

        int res[] = new int[nums.length];

        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
            suffix[nums.length - 1 - i] = suffix[nums.length - i] * nums[nums.length - 1 - i];
        }

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) res[i] = suffix[i + 1];
            else if (i == nums.length - 1) res[i] = prefix[i - 1];
            else res[i] = suffix[i + 1] * prefix[i - 1];
        }

        return res;
    }
}  
