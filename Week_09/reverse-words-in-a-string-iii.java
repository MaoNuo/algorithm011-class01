class Solution {
    public String reverseWords(String s) {
        char[] datas = s.toCharArray();
        int start = 0;
        while (start < datas.length && datas[start] == ' ') { start++; }
        int end = start;
        while (end < datas.length) {
            while (end < datas.length && datas[end] != ' ') { end++; }
            reverse(datas, start, end - 1);
            start = end + 1;
            while (start < datas.length && datas[start] == ' ') { start++; }
            end = start;
        }
        return new String(datas);
    }

    private void reverse(char[] datas, int start, int end) {
        while (start < end) {
            char temp = datas[start];
            datas[start] = datas[end];
            datas[end] = temp;
            start++;
            end--;
        }
    }
}
