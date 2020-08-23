class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') { end--; }
        int start = end;
        while (start >= 0) {
            while (start - 1 >= 0 && s.charAt(start - 1) != ' ') { start--; }
            String word = s.substring(start, end + 1);
            if (sb.length() != 0) {
                sb.append(" " + word);
            } else {
                sb.append(word);
            }
            end = start - 1;
            while (end >= 0 && s.charAt(end) == ' ') { end--; }
            start = end;
        }
        return sb.toString();
    }
}
