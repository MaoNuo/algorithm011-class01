import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    //1.暴力法
    /*
        对于每一个字符在原字符串中进行匹配，匹配到将原位置改为空
        若不存在该字符，则返回false
        时间复杂度为O（n^2）
     */
//    public boolean isAnagram(String s, String t) {
//        if (s.length() == t.length()) {
//            char[] s_ch = s.toCharArray();
//            for (char ch : t.toCharArray()) {
//                boolean flag = false;
//                for (int i = 0 ; i < s_ch.length ; i++) {
//                    if (ch == s_ch[i]) {
//                        s_ch[i] = ' ';
//                        flag = true;
//                        break;
//                    }
//                }
//                if (!flag) return false;
//            }
//            return true;
//        }
//        return false;
//    }

    //2.利用HashMap
    /*
        先将原字符串中存在的字符及次数保存
        然后对于查询字符串中的每一个字符
        存在则减1，若不存在或者已为0，则返回false
        时间复杂度为O（n）
     */
//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        Map<Character,Integer> map = new HashMap<>();
//        for (char ch : s.toCharArray()) {
//            map.put(ch,map.getOrDefault(ch,0) + 1);
//        }
//        for (char ch : t.toCharArray()) {
//            if (!map.containsKey(ch) || map.get(ch) <= 0) return false;
//            else {
//                map.put(ch,map.get(ch) - 1);
//            }
//        }
//        return true;
//    }

    //3.暴力法简化
    /*
        字符串数组排序后检查是否相等
     */
     public boolean isAnagram(String s, String t) {
         char[] s_ch = s.toCharArray();
         char[] t_ch = t.toCharArray();
         Arrays.sort(s_ch);
         Arrays.sort(t_ch);
         return Arrays.equals(s_ch,t_ch);
     }
}