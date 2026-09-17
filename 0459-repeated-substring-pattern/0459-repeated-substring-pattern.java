class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        
        // A valid repeated substring can at most be half the length of s
        for (int len = n / 2; len >= 1; len--) {
            if (n % len == 0) {
                int numRepeats = n / len;
                String substring = s.substring(0, len);
                StringBuilder sb = new StringBuilder();
                
                for (int i = 0; i < numRepeats; i++) {
                    sb.append(substring);
                }
                
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}