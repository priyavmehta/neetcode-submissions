class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int i = 0, stopLoop = 0;
        while (true) {
            char current = 'a';
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].length() == i) {
                    stopLoop = 1;
                    break;
                }
                if (j == 0) {
                    current = strs[j].charAt(i);
                } else if (strs[j].charAt(i) != current) {
                    stopLoop = 1;
                    break;
                }
            }
            if (stopLoop == 1) break;
            sb.append(current);
            i++;
        }

        return sb.toString();
    }
}