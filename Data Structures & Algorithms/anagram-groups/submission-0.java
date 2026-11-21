class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> groups = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            int items[] = new int[26];
            for (int j = 0; j < strs[i].length(); j++) {
                int ascii = strs[i].charAt(j) - 'a';
                items[ascii] += 1;
            }

            String key = Arrays.toString(items);
            groups.putIfAbsent(key, new ArrayList<String>());
            groups.get(key).add(strs[i]);
        }

        return new ArrayList<>(groups.values());
    }
}
