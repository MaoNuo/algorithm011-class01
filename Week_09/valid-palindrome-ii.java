class Solution {
    public boolean validPalindrome(String s) {
        char[] datas = s.toCharArray();
        int lo = 0, hi = datas.length - 1;
        while (lo < hi) {
            if (datas[lo] == datas[hi]) {
                lo++; hi--;
            } else {
                boolean flag1 = true;
                boolean flag2 = true;
                for (int i = lo, j = hi - 1; i < j; i++, j--) {
                    if (datas[i] != datas[j]) {
                        flag1 = false;
                        break;
                    }
                }
                
                for (int i = lo + 1, j = hi; i < j; i++, j--) {
                    if (datas[i] != datas[j]) {
                        flag2 = false;
                        break;
                    }
                }
                
                return flag1 || flag2;
            }
        }

        return true;
    }
}
