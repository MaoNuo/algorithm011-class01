import java.util.PriorityQueue;
import java.util.Random;

public class Sort {
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    /*
        原始数组arr
        [37, 22, 34, 33, 14, 27, 45, 14, 27, 26, 26, 5]
        Bubble sort
        [5, 14, 14, 22, 26, 26, 27, 27, 33, 34, 37, 45]
     */

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    /*
        原始数组arr
        [14, 35, 48, 25, 49, 28, 43, 44, 38, 49, 29, 3, 4, 9, 18, 45, 5, 46]
        Select sort
        [3, 4, 5, 9, 14, 18, 25, 28, 29, 35, 38, 43, 44, 45, 46, 48, 49, 49]
     */

    public static void quickSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    /*
        原始数组arr
        [34, 5, 15, 11, 14, 9, 5, 46, 31, 3, 6, 31, 15, 34, 33, 38, 26]
        Quick sort
        [3, 5, 5, 6, 9, 11, 14, 15, 15, 26, 31, 31, 33, 34, 34, 38, 46]
     */
    private static void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = end;
        int count = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < arr[pivot]) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
        int temp = arr[pivot];
        arr[pivot] = arr[count];
        arr[count] = temp;
        return count;
    }

    public static void mergeSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        mergeSort(arr, 0, arr.length - 1);
    }
    /*
        原始数组arr
        [46, 7, 19, 26, 32, 30, 5, 34, 1, 34, 23, 18, 35, 29, 47, 28, 37, 28, 31]
        Merge sort
        [1, 5, 7, 18, 19, 23, 26, 28, 28, 29, 30, 31, 32, 34, 34, 35, 37, 46, 47]
     */

    private static void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) >>> 1;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int left = start, right = mid + 1;
        int index = 0;
        while (left <= mid && right <= end) {
            if (arr[left] < arr[right]) {
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[index++] = arr[left++];
        }
        while (right <= end) {
            temp[index++] = arr[right++];
        }
        System.arraycopy(temp, 0, arr, start, temp.length);
    }

//    public static void heapSort(int[] arr) {
//        PriorityQueue<Integer> heap = new PriorityQueue<>();
//        for (int num : arr) {
//            heap.add(num);
//        }
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = heap.poll();
//        }
//    }
    /*
        原始数组arr
        [5, 7, 31, 7, 47, 46, 25, 9, 11, 2, 49, 15, 3, 4, 7]
        Heap sort
        [2, 3, 4, 5, 7, 7, 7, 9, 11, 15, 25, 31, 46, 47, 49]
     */
    

    private static void print(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println(arr[arr.length - 1] + "]");
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int len = rand.nextInt(20);
        while (len == 0) {
            len = rand.nextInt();
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = rand.nextInt(50);
        }
        System.out.println("原始数组arr");
        print(arr);
//        System.out.println("Bubble sort");
//        bubbleSort(arr);
//        print(arr);
//        System.out.println("Select sort");
//        selectSort(arr);
///       print(arr);
//        System.out.println("Quick sort");
//        quickSort(arr);
//        print(arr);
//        print(arr);
//        System.out.println("Merge sort");
//        mergeSort(arr);
//        print(arr);
        System.out.println("Heap sort");
//        heapSort(arr);
        print(arr);
    }
}
