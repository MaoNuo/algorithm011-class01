class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 ; i --) {
            if (carry == 0) break;
            digits[i] = (digits[i] + carry) % 10;
            carry = digits[i] == 0 ? 1 : 0;
        }
        if (carry == 1) {
            int[] demic = new int[digits.length + 1];
            demic[0] = 1;
            return demic;
        }
        return digits;
    }
}
