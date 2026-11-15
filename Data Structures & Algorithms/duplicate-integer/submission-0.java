class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> items = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (items.contains(nums[i])) return true;
            items.add(nums[i]);
        }

        return false;
    }
}