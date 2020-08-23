class Solution {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i += k * 2) {
            if (ch.length - i >= k) {
                reverse(ch, i, k);
            } else {
                reverse(ch, i, ch.length - i);
            }
        }
        return new String(ch);
    }

    private void reverse(char[] ch, int start, int k) {
        for (int i = 0; i < k / 2; i++) {
            char temp = ch[start + i];
            ch[start + i] = ch[start + k - i - 1];
            ch[start + k - i - 1] = temp;
        }
    }

}
