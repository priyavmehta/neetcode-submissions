class Solution {
    public boolean isPalindrome(String s) {
        int start = 0, end = s.length() - 1;

        while (start <= end) {
            char c = s.charAt(start), e = s.charAt(end);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z') && !Character.isLetterOrDigit(c)) {
                start++;
                continue;
            }

            if (!(e >= 'A' && e <= 'Z') && !(e >= 'a' && e <= 'z') && !Character.isLetterOrDigit(e)) {
                end--;
                continue;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;

            start++;
            end--;

        }

        return true;
    }
}
