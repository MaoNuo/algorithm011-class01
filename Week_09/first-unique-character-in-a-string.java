class Solution {
    public int firstUniqChar(String s) {
        int res = s.length();
        for (char i = 'a'; i <= 'z'; i++) {
            int first = s.indexOf(i);
            int last = s.lastIndexOf(i);
            if (first == -1) { continue; }
            if (first == last) {
                res = Math.min(res, first);
            }
        }
        return res == s.length() ? -1 : res;
    }

    public static void main(String[] args) {
        new Solution().firstUniqChar("leetcode");
    }
}
