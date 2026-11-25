class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                int num = map.getOrDefault(nums[i] - 1, 0) + map.getOrDefault(nums[i] + 1, 0) + 1;
                map.put(nums[i], num);
                map.put(nums[i] - map.getOrDefault(nums[i] - 1, 0), num);
                map.put(nums[i] + map.getOrDefault(nums[i] + 1, 0), num);
                res = Math.max(num, res);
            }
        }

        return res;
    }
}
