import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
//    public int[] getLeastNumbers(int[] arr, int k) {
//        //使用优先队列，即小顶堆
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : arr) {
//            heap.add(num);
//        }
//        int[] ans = new int[k];
//        for (int i = 0; i < k; i++) {
//            ans[i] = heap.poll();
//        }
//        return ans;
//    }

//    public int[] getLeastNumbers(int[] arr, int k) {
//        //使用大顶堆，当堆中元素数量大于k时弹出，仅当当前元素小于堆顶元素时入堆
//        PriorityQueue<Integer> heap = new PriorityQueue<>((n1,n2) -> n2 - n1);
//        for (int num : arr) {
//            if (heap.isEmpty() || heap.size() < k || num < heap.peek()) {
//                heap.add(num);
//            }
//            if (heap.size() > k) {
//                heap.poll();
//            }
//        }
//        int[] ans = new int[k];
//        for (int i = 0 ; i < k ; i++) {
//            ans[i] = heap.poll();
//        }
//        return ans;
//    }

    public int[] getLeastNumbers(int[] arr, int k) {
        //快速排序的变形：快速选择
        /*
            核心思想：快排的每一次遍历都可以把数组分成两个部分
                    并且这两个部分虽然无序，但一定都小于或大于指定的参照数
                    如果小的那一部分的数量比k大，则递归，答案一定在小的那一部分中
                    如果小的部分的数量比k小，那么需要递归右边那一部分即可
         */
        //k - 1的意义 : 这里是传的最后一个数的下标，所以是k - 1
        quickselect(arr,0,arr.length - 1,k - 1);
        return Arrays.copyOfRange(arr,0,k);
    }

    private void quickselect(int[] nums, int start, int end, int k) {
        if (start == end) {
            return;
        }
        //选择参照数
        int pivot = nums[start];
        //设置左右指针
        int i = start,j = end;
        //遍历整个数组
        while (i <= j) {
            //分别找到不符合该部分条件的数
            while (i <= j && nums[i] < pivot) { i++; }
            while (i <= j && nums[j] > pivot) { j--; }
            if (i <= j) {
                //进行交换
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        //start <= k : 即开始起点比k小，需要接着找起点部分的右半部分
        //k <= j ： 即左边界要比k大
        //所以重新选择左半部分数组
        if (start <= k && k <= j) {
            quickselect(nums,start,j,k);
            //i <= k : 即左半部分数量比k小，需要在右半部分中继续递归
            //k <= end : 即总数量还是大于k，需要再一次的递归
        } else if (i <= k && k <= end) {
            quickselect(nums,i,end,k);
        }
    }
}