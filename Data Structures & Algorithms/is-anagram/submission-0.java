class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> chars = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char s_ch = s.charAt(i);
            char t_ch = t.charAt(i);

            chars.put(s_ch, chars.getOrDefault(s_ch, 0) + 1);
            chars.put(t_ch, chars.getOrDefault(t_ch, 0) - 1);
        }

        for (Integer value : chars.values()) {
            if (value != 0) return false;
        }

        return true;
    }
}
