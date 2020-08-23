class Solution {
    public String reverseOnlyLetters(String S) {
        char[] datas = S.toCharArray();
        int start = 0;
        int end = datas.length - 1;
        while (start < end) {
            while (start < end && !Character.isLetter(datas[start])) { start++; }
            while (start < end && !Character.isLetter(datas[end])) { end--; }

            char temp = datas[end];
            datas[end] = datas[start];
            datas[start] = temp;
            start++;
            end--;
        }

        return new String(datas);
    }
}
