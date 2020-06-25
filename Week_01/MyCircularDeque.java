/*
    使用一个int数组datas保存数据
    capacity表示该数组的最大容量
    size表示当前数组的容量
 */
class MyCircularDeque {
    int capacity;
    int size ;
    int[] datas;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.size = 0;
        this.capacity = k;
        this.datas = new int[k];
    }

    /*
        只有当插入该数后的容量不大于最大容量时能够插入，返回true
        如果插入前该数组为空，则直接放入0位置
        如果不为空，则将数组向后整体移一位，之后把数据插入0位置
     */
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size + 1 <= capacity) {
            if (size == 0) {
                datas[size++] = value;
            }else {
                System.arraycopy(datas,0,datas,1,size);
                datas[0] = value;
                size++;
            }
            return true;
        }else {
            return false;
        }
    }

    /*
        同insertFront，只有数组还有插入的空间时返回true
        只需将数据插入最后即可
     */
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size + 1 <= capacity) {
            datas[size++] = value;
            return true;
        }else {
            return false;
        }
    }

    /*
        数组为空时无法删除，返回false
        将位置1到size -1的数据整体向前移一位即可
     */
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            return false;
        }
        System.arraycopy(datas,1,datas,0,--size);
        return true;
    }

    /*
        同deleteFront，无数据时返回false
        size - 1 即可
     */
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            return false;
        }
        size--;
        return true;
    }

    /*
        数组为空时返回-1
        否则返回首位数据
     */
    /** Get the front item from the deque. */
    public int getFront() {
        if (size == 0) {
            return -1;
        }else {
            return datas[0];
        }
    }

    /*
        数组为空时返回 -1
        否则返回最后一位数据
     */
    /** Get the last item from the deque. */
    public int getRear() {
        if (size == 0) {
            return -1;
        }else {
            return datas[size - 1];
        }
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */