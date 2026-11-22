class Solution {

    public String encode(List<String> strs) {
        String res = "";
        if (strs.size() == 0) return "";

        for (String s: strs) {
            res += s.length() + "#" + s;
        }
        return res;
    }

    public List<String> decode(String str) {
        int prevHash = 0, i = 0;
        List<String> res = new ArrayList<>();
        while (i < str.length()) {
            if (str.charAt(i) == '#') {
                int length = Integer.parseInt(str.substring(prevHash, i));
                if (length == 0) {
                    res.add("");
                } else {
                    res.add(str.substring(i + 1, i + 1 + length));
                }
                prevHash = i + 1 + length;
                i = prevHash;
            } else {
                i++;
            }
        }
        return res;
    }
}
