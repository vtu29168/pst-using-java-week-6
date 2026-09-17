class Solution {
    private int start = 0;
    private int maxLength = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            // Odd length palindromes (e.g., "aba")
            expandAroundCenter(s, i, i);
            // Even length palindromes (e.g., "abba")
            expandAroundCenter(s, i, i + 1);
        }

        return s.substring(start, start + maxLength);
    }

    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        
        // Length of palindrome found is (right - 1) - (left + 1) + 1 = right - left - 1
        int length = right - left - 1;
        if (length > maxLength) {
            start = left + 1;
            maxLength = length;
        }
    }
}