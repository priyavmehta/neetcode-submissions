class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> items = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            items.put(nums[i], items.getOrDefault(nums[i], 0) + 1);
        }

        List<int[]> list = new ArrayList<>();

        items.forEach((ele, count) -> {
            list.add(new int[]{ele, count});
        });

        list.sort((a,b) -> b[1] - a[1]);

        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i)[0];
        }

        return res;
    }
}
