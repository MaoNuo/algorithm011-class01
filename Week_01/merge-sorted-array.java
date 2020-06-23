import java.util.Arrays;

class Solution {
//    两个数组分别对应两个指针
//    其中nums1为目标数组
//    对比两个数组对应指针的数值大小
//    如果nums1中的数较小，则保持不动，指针后移
//    如果nums2中的数较小，则寻找nums1这个数应该存在的位置
//    当nums1的指针移动到末尾时，将nums2复制到剩余位置上

//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (nums2.length == 0) return;
//        int i = 0 , j = 0;
//        while (i < m) {
//            if (nums1[i] <= nums2[j]) i++;
//            else {
//                int temp = nums1[i];
//                nums1[i++] = nums2[j];
//                while (j < n - 1 && nums2[j + 1] < temp) {
//                    nums2[j] = nums2[j + 1];
//                    j++;
//                }
//                nums2[j] = temp;
//                j = 0;
//            }
//        }
//        for (int k = 0; k < n; k++) {
//            nums1[m + k] = nums2[k];
//        }
//    }

//    //合并后排序
//    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        System.arraycopy(nums2,0,nums1,m,n);
//        Arrays.sort(nums1);
//    }

    //从后往前双指针
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //当前应插入位置 : n + m - 1
        //当前nums1指针位置 ： m - 1
        //当前nums2指针位置 ： n - 1
        while (n > 0) {
            if (m == 0) {
                System.arraycopy(nums2,0,nums1,0,n);
                break;
            }
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[n + m - 1] = nums1[--m];
            }else {
                nums1[n + m - 1] = nums2[--n];
            }
        }
    }
}