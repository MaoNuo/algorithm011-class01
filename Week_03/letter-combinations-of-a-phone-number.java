class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<String>();
        }
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, map, digits, 0);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder sb, Map<Character,String> map, String digits, int len) {
        if (len == digits.length()) {
            result.add(sb.toString());
            return;
        }

        String str =  map.get(digits.charAt(len));
        for (char ch : str.toCharArray()) {
            sb.append(ch);
            backtrack(result, sb, map, digits, len + 1);
            sb.deleteCharAt(len);
        }
    }
}
